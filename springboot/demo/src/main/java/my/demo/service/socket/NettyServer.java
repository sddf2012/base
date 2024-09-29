package my.demo.service.socket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import org.springframework.stereotype.Component;


/**
 * @author liu peng bo
 * @date 2024/09/27 17:02
 */
@Component
public class NettyServer {

    private final int port = 8088; // 设置服务器端口

    public void start() throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast(new HttpServerCodec());
                            ch.pipeline().addLast(new WebSocketServerProtocolHandler("/ws"));
                            ch.pipeline().addLast(new SimpleChannelInboundHandler<TextWebSocketFrame>() {
                                @Override
                                protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) {
                                    // 处理收到的消息
                                    System.out.println("Received: " + msg.text());
                                    // 回复客户端
                                    ctx.channel().writeAndFlush(new TextWebSocketFrame("Echo: " + msg.text()));
                                }
                            });
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128) // 设置 backlog
                    .childOption(ChannelOption.SO_KEEPALIVE, true); // 保持连接

            ChannelFuture future = bootstrap.bind(port).sync();
            System.out.println("WebSocket Server started on port: " + port);
            future.channel().closeFuture().sync(); // 等待关闭
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}

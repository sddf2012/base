package my.nio.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 * @author liu peng bo
 * @date 2024/09/20 16:39
 */
public class NettyClient2 {
    public static void main(String[] args) throws InterruptedException, IOException {
        EventLoopGroup group = new NioEventLoopGroup(1);
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyClientHandler());
                            // 可以在这里添加编码器和解码器等其他处理逻辑
                        }
                    });

            // 连接到服务器
            ChannelFuture future = bootstrap.connect("localhost", 6668).sync();
            // 从控制台读取输入并发送
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String msg = scanner.nextLine();
                future.channel().writeAndFlush(Unpooled.copiedBuffer(msg, CharsetUtil.UTF_8));
                if ("exit".equals(msg)) {
                    System.out.println(System.currentTimeMillis() + " 客户端退出");
                    break;
                }
            }
            // 关闭连接
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

}

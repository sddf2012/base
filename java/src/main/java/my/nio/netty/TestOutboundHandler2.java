package my.nio.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import java.net.SocketAddress;

/**
 * @author liu peng bo
 * @date 2024/09/14 15:40
 */
public class TestOutboundHandler2 extends ChannelOutboundHandlerAdapter {
    @Override
    public void flush(ChannelHandlerContext ctx) throws Exception {
        System.out.println(Thread.currentThread().getName() + " out-2 flush");
        super.flush(ctx);
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println(Thread.currentThread().getName() + " out-2 write");
        super.write(ctx, msg, promise);
    }

    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
        System.out.println(Thread.currentThread().getName() + " out-2 read");
        super.read(ctx);
    }

    @Override
    public void deregister(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        System.out.println(Thread.currentThread().getName() + " out-2 deregister");
        super.deregister(ctx, promise);
    }

    @Override
    public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        System.out.println(Thread.currentThread().getName() + " out-2 close");
        super.close(ctx, promise);
    }

    @Override
    public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        System.out.println(Thread.currentThread().getName() + " out-2 disconnect");
        super.disconnect(ctx, promise);
    }

    @Override
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        System.out.println(Thread.currentThread().getName() + " out-2 connect");
        super.connect(ctx, remoteAddress, localAddress, promise);
    }

    @Override
    public void bind(ChannelHandlerContext ctx, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        System.out.println(Thread.currentThread().getName() + " out-2 bind");
        super.bind(ctx, localAddress, promise);
    }
}

package my.nio;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SimpleNIOServer {

    public static ConcurrentLinkedQueue<String> msgQueue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) throws Exception {
        // 创建 Selector 和 Channel
        Selector selector = Selector.open();
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress("localhost", 8888));
        serverSocket.configureBlocking(false);
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);

        Thread thread = new Thread(() -> {
            try {
                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNextLine()) {
                    String msg = scanner.nextLine();
                    if (msg != null) {
                        msgQueue.offer(msg);
                        broadcast(selector);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();

        while (true) {
            selector.select(); // 阻塞，直到至少有一个注册的事件发生
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> iter = selectedKeys.iterator();

            //broadcast(selector);

            while (iter.hasNext()) {
                SelectionKey key = iter.next();

                if (key.isAcceptable()) {
                    register(selector, serverSocket);
                }

                if (key.isReadable()) {
                    read(key);
                }
                iter.remove();
            }
        }
    }

    private static void register(Selector selector, ServerSocketChannel serverSocket) throws Exception {
        SocketChannel client = serverSocket.accept();
        client.configureBlocking(false);
        client.register(selector, SelectionKey.OP_READ);
        System.out.println(client.getRemoteAddress() + " connected ...");
    }

    private static void read(SelectionKey key) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(256);
        SocketChannel channel = (SocketChannel) key.channel();
        InetSocketAddress address = (InetSocketAddress) channel.getRemoteAddress();
        int num = channel.read(buffer);
        if (num == -1) {
            channel.close();
            System.out.println(address + " connection closed...");
        } else {
            buffer.flip();
            System.out.println(address.getPort() + ": " + new String(buffer.array()).trim());
            buffer.clear();
        }
    }

    private static void broadcast(Selector selector) throws Exception {
        if (!msgQueue.isEmpty()) {
            for (SelectionKey key : selector.keys()) {
                if (key.isValid() && key.channel() instanceof SocketChannel) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    channel.write(ByteBuffer.wrap(msgQueue.poll().getBytes()));
                }
            }
        }
    }
}

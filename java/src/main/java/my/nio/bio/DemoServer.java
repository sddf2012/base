package my.nio.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liu peng bo
 * @date 2022/1/10 下午4:24
 */
public class DemoServer extends Thread {
    private ServerSocket serverSocket;
    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(6667);
            while (true) {
                Socket socket = serverSocket.accept();
                RequestHandler requestHandler = new RequestHandler(socket);
                requestHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        DemoServer server = new DemoServer();
        server.start();

    }
}

// 简化实现，不做读取，直接发送字符串
class RequestHandler extends Thread {
    private Socket socket;

    RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream());) {
            Thread.sleep(2000);
            out.println("Hello world!");
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


package my.nio;

import java.io.*;
import java.net.*;
import java.util.Random;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // 服务器地址
        int port = 8888; // 服务器端口

        try (Socket socket = new Socket(serverAddress, port)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            String str = null;
            while (true) {
                str = reader.readLine();
                out.write(str);
                if ("exit".equals(str))
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

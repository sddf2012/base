package my.base.file;

import java.io.*;
import java.nio.file.Files;

public class FileDemo {
    public static void main(String[] args) throws Exception {
        createFile();
    }

    public static void createFile() throws IOException {
        //File file = new File("C:\\Users\\Administrator\\Desktop\\json", "123.txt");
        File file = new File("C:\\Users\\Administrator\\Desktop\\test\\test\\123.txt");
        if(!file.exists()){
             if(!file.getParentFile().exists()){
                 file.getParentFile().mkdirs();
             }
            file.createNewFile();
        }
        //file.mkdirs();
        String content="sdfdsfdsfsf";
        OutputStream stream= Files.newOutputStream(file.toPath());
        stream.write(content.getBytes());
        stream.flush();
    }
}

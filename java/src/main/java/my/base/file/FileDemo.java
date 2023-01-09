package my.base.file;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class FileDemo {
    public static void main(String[] args) throws Exception {
        //createFile();
        //copy();
        move();
    }

    public static void copy() throws IOException {
        File a=new File("C:\\Users\\Administrator\\Desktop\\test\\test\\123.txt");
        File b=new File("C:\\Users\\Administrator\\Desktop\\test\\123.txt");
        if(b.exists()){
            b.delete();
        }
        Files.copy(a.toPath(),b.toPath());
    }

    public static void move() throws IOException {
        File a=new File("C:\\Users\\Administrator\\Desktop\\test\\123.txt");
        File b=new File("C:\\Users\\Administrator\\Desktop\\test\\test\\123.txt");
        Files.move(a.toPath(),b.toPath());
    }

    public static void test(){
        File file=new File("C:\\Users\\Administrator\\Desktop\\test\\","my");
        System.out.println(file.isFile());
        System.out.println(file.getParentFile().getName());
        System.out.println(file.getName());
        System.out.println(1);
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

    public static void search(){
        File file = new File("C:\\Users\\Administrator\\Desktop\\test");
        String name="123.txt";
        File[] files=file.listFiles();
        File result = Arrays.stream(files).filter(a-> a.isFile()&&a.getName().equals(name)).findFirst().orElse(null);
        System.out.println(result);
    }
}

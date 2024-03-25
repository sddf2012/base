package my.console;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        scanner();
    }

    public static void buffer() {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            String str = null;
            while (true) {
                str = reader.readLine();
                if (!str.equals(""))
                    System.out.println(str);
                else
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void scanner() {
        StringBuilder stringbuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String text = scanner.nextLine().trim();
            if ("".equals(text)) {
                break;
            }
            stringbuilder.append(text);
        }
        System.out.println(stringbuilder.toString());
    }

}

package iava.com.path;
import java.io.File;
import java.nio.file.Files;
import java.util.Scanner;

public class LearnPath {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("输入");
        String lines = scan.nextLine();
        char[] array = lines.toCharArray();//获取字符数组
        for (int i = 0;i<array.length;i++){
            array[i] = (char)(array[i]^20000);
        }
        System.out.println("输出");
        System.err.println(new String(array));
    }
}

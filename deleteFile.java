import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/*
删除流氓文件，成百上千级文件夹
 */
public class deleteFile {

  public static void main(String[] args) throws IOException {
    //获取绝对路径
    Scanner scan = new Scanner(System.in);
    String dirName = scan.nextLine();
//    System.out.println(dirName);
    //文件夹给文件对象
    File dirctory = new File(dirName);
    System.out.println(dirctory.exists());
    File[] dir = dirctory.listFiles();
    //删除目录中的文件
    for (File file : dir) {
      if (file.isFile()) {
        file.delete();
      } else {
        foreachDic(file);
      }
    }
  }
  public static void foreachDic(File file) {
    File[] files = file.listFiles();
    for (File eachFile : files) {
      moveFileToParent(eachFile);
    }
  }
  public static void moveFileToParent(File file){
    String parent = file.getParent();
    String fileName = file.getAbsolutePath();
    System.out.println(parent+"：File");
    System.out.println(fileName+"：File");
    Path absolutParentPath = Paths.get(parent);
    Path absolutFileName = Paths.get(fileName);
    System.out.println(absolutParentPath.toAbsolutePath()+"：Path");
    System.out.println(absolutFileName.toAbsolutePath()+"：Path");
  }

}

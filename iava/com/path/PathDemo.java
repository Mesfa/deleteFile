package iava.com.path;
import java.io.File;
import java.io.IOException;
public class PathDemo {
    public static void main(String[] args) throws IOException {
        /*
         * File类的listFiles()列出当前目录下文件以及文件夹。
         *
         * 需求：能不能列出当前目录下的子目录中的所有内容。
         * 思路：
         * 1，在遍历当前目录时，会获取到当前的所有的文件以及文件夹，
         * 2，要遍历子目录需要对获取到的当前的file对象进行判断，只有是目录才可以作为子目录进行继续遍历，遇到文件直接删除。
         * 3，当遍历到最后一级目录时该目录长度为0，File[]长度为0就直接删除，再调用目录遍历，倒数第二级为0，这样倒着删除
         */

        File dir = new File("D:\\分享APK\\base13");
        listAll(dir);
    }
static int i=0;
    public static void listAll(File dir) throws IOException {// dir:接收目录以及子目录。
        System.out.println("dir:" + dir.getName());
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {// 如果遍历到当前的file对象是个目录，继续遍历。
                File[] fileDemo = file.listFiles();
                if (fileDemo.length == 0) {//将该目录进行判断是否为空目录，空目录就删除，不就继续遍历
                    file.delete();
                    i++;
                } else {
                    listAll(file);//该目录中有文件直接删除
                }

            } else {
                System.out.println("file:" + file.getName());//有文件直接删除
                file.delete();
            }
        }
        dir.delete();
    }


}





import java.io.*;
import java.util.Date;

public class GetFileInfo{
    public static void main(String[] args){
        String filePath = "GetFileInfo.java";
        File file = new File(filePath);
        System.out.println("file name: " + file.getName());
        System.out.println("file exist?: " + file.exists());
        System.out.println("file relative path: " + file.getPath());
        System.out.println("file absolute path: " + file.getAbsolutePath());
        System.out.println("file execute?: " + file.canExecute());
        System.out.println("file can read?: " + file.canRead());
        System.out.println("file can write?: " + file.canWrite());
        System.out.println("file last path: " + file.getParent());
        System.out.println("file size: " + file.length() + "B");
        System.out.println("file last modified time: " + new Date(file.lastModified()));
        System.out.println("is file?: " + file.isFile());
        System.out.println("is directory?: " + file.isDirectory());
    }
}

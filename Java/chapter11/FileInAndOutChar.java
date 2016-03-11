import java.io.*;
import java.util.*;

public class FileInAndOutChar{
    public static void main(String[] args){
        StringBuilder strBuilder = new StringBuilder();
        readFile(strBuilder);
        System.out.println(strBuilder);
        writeFile(strBuilder);
    }
    private static void readFile(StringBuilder strBuilder){
        try{
            String filePath = "FileInAndOutChar.java";
            File file = new File(filePath);
            FileReader fReader = new FileReader(file);
            char[] data = new char[512];
            int rs = 0;
            while((rs = fReader.read(data)) > 0){
                strBuilder.append(data, 0, rs);
            }
            fReader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private static void writeFile(StringBuilder strBuilder){
        try{
            String filePath = "FileInAndOutChar.cfg";
            File file = new File(filePath);
            FileWriter fWriter = new FileWriter(file);
            fWriter.write(strBuilder.toString());
            fWriter.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

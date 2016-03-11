import java.io.*;
import java.util.*;

public class FileInAndOut{
    private static String filePath = "./myProgram.cfg";
    private static File file = new File(filePath);
    // execute times
    private static int runCount = 0;
    // last execute time
    private static String date = String.format("%tF %<tT",new Date());
    // the system executing the program last
    private static String os = System.getProperty("os.name");
    private static String dataStr = "";
    public static void main(String[] args){
        loadConfig();
        if(dataStr.isEmpty()){
            System.out.println("this is your first to execute the program, and no config.");
        }else{
            System.out.println("this is your " + runCount + "th to execute the program.");
            System.out.println("last execute time of the program: " + date);
            System.out.println("last execute os is:" + os);
        }
        putConfig();
    }
    private static void loadConfig(){
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            byte[] data = new byte[64];
            FileInputStream fis = new FileInputStream(file);

            int rs = 0;
            while((rs = fis.read(data)) > 0){
                dataStr += new String(data, 0, rs);
            }
            if(!dataStr.isEmpty()){
                String[] sets = dataStr.split(",");
                runCount = Integer.parseInt(sets[0]);
                date = sets[1];
                os = sets[2];
            }
            fis.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private static void putConfig(){
        String dataStr;
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            dataStr = (runCount+1) + "," + new Date() + "," + os;
            byte[] data = dataStr.getBytes();
            FileOutputStream fout = new FileOutputStream(file);
            fout.write(data);
            fout.flush();
            fout.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


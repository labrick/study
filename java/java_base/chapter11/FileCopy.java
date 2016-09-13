import java.io.*;

public class FileCopy{
    public static void main(String[] args){
        String sfpath = "FileCopy.java";
        String dfpath = "src/FileCopyrepeat.java";
        File sFile = new File(sfpath);
        File dFile = new File(dfpath);
        try{
            dFile.createNewFile();
            FileInputStream fis = new FileInputStream(sFile);
            FileOutputStream fout = new FileOutputStream(dFile);
            byte[] date = new byte[512];
            int rs = -1;
            while((rs = fis.read(date)) > 0){
                fout.write(date, 0, rs);
            }
            fout.close();
            fis.close();
            System.out.println("copy file success!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

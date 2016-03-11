import java.io.*;

public class FileDelete{
    private static void delFile(File file){
        if(!file.exists()){
            System.out.println("file is not exist!");
            return;
        }
        boolean rs = file.delete();
        if(rs){
            System.out.println("file delete success!");
        }else{
            System.out.println("file delete failure!");
        }
    }

    public static void main(String[] args){
        String filePath = "./FileDelete.dat";
        File file = new File(filePath);
        delFile(file);
    }
}

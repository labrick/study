import java.io.*;

public class FolderCopy{
    private static void copy(File[] s, File d){
        if(!d.exists())
            d.mkdir();
        for(int i=0; i<s.length; i++){
            if(s[i].isFile()){
                try{
                    FileInputStream fis = new FileInputStream(s[i]);
                    FileOutputStream out = new FileOutputStream(new File(d.getPath() + File.separator + s[i].getName()));
                    // fis.available what????
                    int count = fis.available();
                    byte[] data = new byte[count];
                    if(fis.read(data) != -1){
                        out.write(data);
                    }
                    out.close();
                    fis.close();
                }catch(Exception e){
                    e.printStackTrace();
                }

            }            if(s[i].isDirectory()){
                File des = new File(d.getPath() + File.separator + s[i].getName());
                des.mkdir();
                copy(s[i].listFiles(),des);
            }
        }
    }
    public static void main(String[] args){
        File sourFile = null, desFile = null;
        String sourFolder = "./sourceFolder";
        String desFolder = "./desFolder";
        sourFile = new File(sourFolder);
        if(!sourFile.isDirectory() || !sourFile.exists()){
            System.out.println("source file is not exist!");
        }
        desFile = new File(desFolder);
        desFile.mkdir();
        copy(sourFile.listFiles(), desFile);
    }
}

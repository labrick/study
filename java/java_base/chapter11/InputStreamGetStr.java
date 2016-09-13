import java.io.*;

public class InputStreamGetStr{
    public static void main(String[] args){
        InputStream is = System.in;
        try{
            byte[] bs = new byte[50];
            int i = is.read(bs);
            System.out.println("Console input context: " + new String(bs).trim());
            is.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

import java.io.*;

public class ReaderStr{
    public static void main(String[] args){
        InputStreamReader rin = new InputStreamReader(System.in);
        try{
            char[] cs = new char[50];
            rin.read(cs);
            String str = new String(cs);
            System.out.println("the String inputed by console: \n\t" + str.trim());
            rin.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

import java.io.*;

public class WriterStr{
    public static void main(String[] args){
        Writer out = new PrintWriter(System.out);
        try{
            char[] cs = "output string to console by using OutputStream\n".toCharArray();
            out.write(cs);
            cs = "output context: \n".toCharArray();
            out.write(cs);
            cs = "      hello world, robot!\n".toCharArray();
            out.write(cs);
            out.flush();
            out.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

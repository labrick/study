import java.io.*;

public class OutputStreamWriteStr{
    public static void main(String[] args){
        OutputStream out = System.out;
        try{
            byte[] bs = "output string to console by using OutputStream\n".getBytes();
            out.write(bs);
            bs = "output context: \n".getBytes();
            out.write(bs);
            bs = "      hello world, robot!\n".getBytes();
            out.write(bs);
            out.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

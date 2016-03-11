import java.io.*;

public class LineWriterData{
    public static void main(String[] args){
        String filePath = "./File.txt";
        File file = new File(filePath);
        try{
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("YN".toCharArray());
            bw.newLine();
            bw.write("welcome to here".toCharArray());
            bw.newLine();
            bw.flush();
            System.out.println("data have writen to File.txt!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

import java.io.*;

public class BufferedReader{
    public static void main(String[] args){
        String content[] = {"long time to see you!", "how are you?", "keep contact!"};
        File file = new File("./word.txt");
        try{
            FileWriter fw = new FileWriter(file);
            BufferedWriter bufw = new BufferedWriter(fw);

            for(int k=0; k<content.length; k++){
                bufw.write(content[k]);
                bufw.newLine();
            }
            bufw.close();
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            FileReader fr = new FileReader(file);
            //**********************************************
            java.io.BufferedReader bufr = new java.io.BufferedReader(fr);

            String s = null;
            int i = 0;
            while((s = bufr.readLine()) != null){
                i++;
                System.out.println(i + "th line: " + s);
            }
            bufr.close();
            fr.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}

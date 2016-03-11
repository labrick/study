import java.io.*;

public class ObjectSerializable{
    public static void main(String[] args) throws Exception{
        try{
            Worker worker = new Worker();
            worker.setAge(27);
            worker.setName("YN");
            worker.setSex("female");
            FileOutputStream fout = new FileOutputStream("./worker.dat");

            ObjectOutputStream oops =new ObjectOutputStream(fout);
            oops.writeObject(worker);
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            FileInputStream fis = new FileInputStream("./worker.dat");
            
            ObjectInputStream oi = new ObjectInputStream(fis);
            Worker newWorker = (Worker)oi.readObject();
            System.out.println("name: " + newWorker.getName());
            System.out.println("sex: " + newWorker.getSex());
            System.out.println("age: " + newWorker.getAge());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

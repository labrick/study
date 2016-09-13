public class CopyOfThreadSafeTest implements Runnable{
    int num = 10;
    public synchronized void doit(){
    //    synchronized(""){
            if(num > 0){
                try{
                    Thread.sleep(100);
                }catch(Exception e){
                    e.printStackTrace();
                }
                System.out.println(" remain tickets: " + num--);
            }
    //    }
    }
    public void run(){
        while(true){
            doit();
        }
    }
    public static void main(String[] args){
        CopyOfThreadSafeTest t = new CopyOfThreadSafeTest();
        Thread tA = new Thread(t);
        Thread tB = new Thread(t);
        Thread tC = new Thread(t);
        Thread tD = new Thread(t);
        tA.start();
        tB.start();
        tC.start();
        tD.start();
    }
}

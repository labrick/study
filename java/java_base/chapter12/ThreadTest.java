public class ThreadTest extends Thread{
    private int count = 10;
    public void run(){
        for(int i=0; i<10 ;i++){
            System.out.println("MainThread: " + i);
            //try{
            //    Thread.sleep(1000);
            //} catch (InterruptedException e) {
            //    e.printStackTrace(); 
            //}
        }
    }
    public static void main(String[] args){
        new ThreadTest().start();
        for(int i=0; i<10 ;i++){
            System.out.println("SubThread: " + i);
            //try{
            //    Thread.sleep(1000);
            //} catch (InterruptedException e) {
            //    e.printStackTrace(); 
            //}
        }
    }
}

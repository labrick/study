public class ThreadDemo implements Runnable{
    @Override
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println("TestThread is running...");
        }
    }
    public static void main(String[] args){
        ThreadDemo demo = new ThreadDemo();
        new Thread(demo).start();
        for(int i=0; i<10; i++){
            System.out.println("main thread is running...");
        }
    }
}

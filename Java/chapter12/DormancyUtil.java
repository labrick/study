public class DormancyUtil implements Runnable{
    public void run(){
        int count = 0;
        while(true){
            try{
                Thread.sleep(100);
                System.out.print(++count + "\t");
                if(count % 10 == 0){
                    System.out.println("");
                }
                if(count == 100){
                    break;
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        DormancyUtil util = new DormancyUtil();
        new Thread(util).start();
    }
}

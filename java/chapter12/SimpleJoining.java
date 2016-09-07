class Sleeper extends Thread{
    private int sleeptime;
    public Sleeper(String name, int sleeptime){
        super(name);
        sleeptime = sleeptime;
        start();
    }
    public void run(){
        try{
            for(int i=0; i<5; i++){
                System.out.println(getName() + " print " + i);
                sleep(sleeptime);
            }
        }catch(InterruptedException e){
            System.out.println(getName() + " interrupted");
        }
        System.out.println(getName() + " executed over!");
    }
}

class Joiner extends Thread{
    private Sleeper sleeper;
    public Joiner(String name, Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }
    public void run(){
        try{
            System.out.println(getName() + " start executing...");
            System.out.println(sleeper.getName() + " start using join() mothed");
            sleeper.join();
            for(int i=5; i>0; i--){
                System.out.println(getName() + " print " + i);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(getName() + " executed over!");
    }
    public static void main(String[] args){
        Sleeper sleeper1 = new Sleeper("thread A sleeper1", 1500), sleeper2 = new Sleeper("thread B sleeper2", 1500);
        Joiner joiner = new Joiner("thread B", sleeper2);
        sleeper1.interrupt();
    }
}

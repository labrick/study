public class SimplePriorities extends Thread{
    public SimplePriorities(int priority, String name){
        setPriority(priority);
        setName(name);
        start();
    }
    public String toString(){
        return super.toString()+":"+getName();
    }
    public void run(){
        int countdown = 3;
        while(true){
            System.out.println(this);
            if(--countdown == 0)
                return;
        }
    }
    public static void main(String[] args){
        for(int i=0; i<5; i++){
            if(i == 3){
                new SimplePriorities(Thread.MAX_PRIORITY,"highest priority thread - " + i);
                continue;
            }
            new SimplePriorities(Thread.NORM_PRIORITY, "lowest priority thread - " + i);
        }
        new SimplePriorities(8, "higtest priority thread");
    }
}

class Water{
    static Object water = new Object();
    static int total = 6;
    static int mqsl = 3;    // amount of current water
    static int ps = 0;      // amount of current drain
    public static void main(String[] args){
        ThreadA tA = new ThreadA();
        ThreadB tB = new ThreadB();
        tA.start();
        tB.start();
    }
}

// Thread drain water
class ThreadA extends Thread{
    void pswork(){
        synchronized(Water.water){
            System.out.println("pool is empty?: " + isEmpty());
            if(isEmpty()){
                try{
                    Water.water.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }else{
                Water.ps++;
                System.out.println("amount of current drain water: " + Water.ps);
            }
            System.out.println("Water.ps: " + Water.ps);
        }
    }

    public boolean isEmpty(){
        return (Water.mqsl==Water.ps) ? true : false;
    }

    public void run(){
        while(Water.mqsl < Water.total){
            if(isEmpty()){
                System.out.println("pool hava no water, drain thread is suspend!");
            }
            System.out.println("drain water start...");
            pswork();
            try{
                sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class ThreadB extends Thread{
    void jswork(){
        synchronized(Water.water){
            Water.mqsl++;
            Water.water.notify();
            System.out.println("amount of current water: " + Water.mqsl);
        }
    }
    public void run(){
        while(Water.mqsl < Water.total){
            System.out.println("pour water start...");
            jswork();
            try{
                sleep(3000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

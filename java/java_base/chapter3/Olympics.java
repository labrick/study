public class Olymptics{
    private int medal_All = 800;
    public void china(){
        int medal_CN = 100;
        if(true){
            int gold = 50;
            medal_CN += 50;
            medal_All -= 150;
        }
        //gold = 100;         // error
        medal_CN += 100;
        medal_All -= 200;
    }
    public void Other(){
        medal_All = 800;
        //medal_CN = 100;     // error
        //gold = 10;          // error
    }
}

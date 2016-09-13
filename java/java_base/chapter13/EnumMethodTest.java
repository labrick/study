import static java.lang.System.out;

public class EnumMethodTest{
    enum Constants2{
        Constants_A,Constants_B;
    }
    public static void compare(Constants2 c){
        for(int i=0; i<Constants2.values().length; i++){
            out.println("result of comparing " + c + " and " + Constants2.values()[i] + " : " + c.compareTo(Constants2.values()[i]));
        }
    }
    public static void main(String[] args){
        compare(Constants2.valueOf("Constants_B"));
    }
}

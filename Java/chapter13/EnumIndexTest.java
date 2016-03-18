import static java.lang.System.out;

public class EnumIndexTest{
    enum Constants2{
        Constants_A,Constants_B;
    }
    public static void main(String[] args){
        for(int i=0; i<Constants2.values().length; i++){
            out.println("the index of " + Constants2.values()[i] + " in Constants is " + Constants2.values()[i].ordinal());
        }
    }
}

import static java.lang.System.out;

public class ShowEnum{
    enum Constants2{
        Constants_A,Constants_B;
    }
    public static void main(String[] args){
        for(int i=0; i<Constants2.values().length; i++){
            out.println("enum member variable: " + Constants2.values()[i]);
        }
    }
}

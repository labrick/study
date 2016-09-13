public class Pactorial{
    public static void main(String[] args){
        int pact = 1;
        for(int i=4; i>0; i--){
            pact *= i;
        }
        System.out.println("pact of 16 is  " + pact);
    }
}

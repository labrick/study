public class Shoot{
    static void pop() throws NegativeArraySizeException{
        int[] arr = new int[-3];
    }
    public static void main(String[] args){
        try{
            pop();
        }catch(NegativeArraySizeException e){
            System.out.println("Exception throwed by pop()");
        }
    }
}

public class MyException extends Exception{
    String message;
    public MyException(String ErrorMessage){
        super(ErrorMessage);
    }
}

public class AnyThting{
    public AnyThting(){
        // the pointer this must used in the first line
        this("this call construct method with some params");
        System.out.println("construct method without params");
    }
    public AnyThting(String name){
        System.out.println("params :" + name);
        System.out.println("construct method with some params");    
    }
    public static void main(String[] args){
        AnyThting anyThting = new AnyThting();
        System.out.println("hello world!");
    }
}

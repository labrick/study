public class Farm{
    public static void main(String[] args){
        System.out.println("call Apple's harvest() :");
        Fruit apple = new Apple();      // apple belongs to class of Fruit??
        apple.harvest();
        System.out.println("call Orange's harvest() :");
        Fruit orange = new Orange();
        orange.harvest();
    }
}

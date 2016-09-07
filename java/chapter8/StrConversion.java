public class StrConversion{
    public static void main(String[] agrs){
        String str = null;
        str = String.format("Hi, %s", "yanan");
        System.out.println(str);
        System.out.printf("Upper of charactor 'a' is %c %n", 'A');
        System.out.printf("result of 3>7 is %b %n", 3>7);
        System.out.printf("half of 100 is %d %n", 100/2);
        System.out.printf("hex format of 100 is %x %n", 100);
        System.out.printf("oct format of 100 is %o %n", 100);
        System.out.printf("8.5 discount of $50 book is %f %n", 50*0.85);
        System.out.printf("hex format of the book price is %a %n", 50*0.85);
        System.out.printf("zhishu format of the book price is %e %n", 50*0.85);
        System.out.printf("general format of the book price is %g %n", 50*0.85);
        System.out.printf("the discount is %d%% %n", 85);
        System.out.printf("sanlie code of charactor 'A' is %h %n", 'A');

    }
}

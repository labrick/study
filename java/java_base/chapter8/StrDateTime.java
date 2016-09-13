public class StrDateTime{
    public static void main(String[] agrs){
        String str = null;
        str = String.format("$ usage: %1$d,%2$s", 99,"yanan");
        System.out.println(str);
        System.out.printf("the charactor of display the plus/minus: %+d and %d%n", 99, -99);
        System.out.printf("the best num is %03d%n", 7);
        System.out.printf("the effect of TAB KEY is % 8d%n", 7);
        System.out.printf("the effect of divide the integer is %,d%n", 9989997);
        System.out.printf("the price of a book is $%2.2f%n", 49.8);

    }
}

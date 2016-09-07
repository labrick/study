public class StrSearch{
    public static void main(String[] args){
        String str = "lab302mayanan";
        int rs = str.indexOf('a');
        System.out.println("location of char 'a' first display is " + rs);
        rs = str.lastIndexOf('a');
        System.out.println("location of char 'a' last display is " + rs);
        rs = str.lastIndexOf("ab");
        System.out.println("location of string \"ab\" first display is " + rs);
        rs = str.indexOf('a', 4);
        System.out.println("location of char 'a' first display after fifth char is " + rs);
    }
}

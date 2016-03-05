public class Thundering{
    public static void main(String[] args){
        try{
            String str = "lili";
            System.out.print(str + "'s age is: ");
            int age = Integer.parseInt("20L");
            System.out.println(age);
        }catch(Exception e){
            e.getMessage();
        }
        System.out.println("\nprogram over");
    }
}

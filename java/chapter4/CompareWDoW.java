public class CompareWDoW{
    public static void main(String[] args){
        int i = 1;
        int sum = i;
        System.out.println("********when i=" + i + "********");
        System.out.println("by do ... while:");
        do{
            System.out.println(i);
            i++;
            sum += i;
        }while( sum<10 );
        i = 1;
        sum = i;
        System.out.println("by while:");
        while( sum<10 ){
            System.out.println(i);
            i++;
            sum += i;
        }
        i = 10;
        sum = i;
        System.out.println("********while i=" + i + "********");
        System.out.println("by do ... while:");
        do{
            System.out.println(i);
            i++;
            sum += i;
        }while( sum<10 );
        i = 10;
        sum = i;
        System.out.println("by while:");
        while( sum<10 ){
            System.out.println(i);
            i++;
            sum += i;
        }

        System.out.println("********Test foreach********");
        int[] array = {12,43,43,22,13,58};
        for(int j : array){
            System.out.println(j);
        }
    }
}

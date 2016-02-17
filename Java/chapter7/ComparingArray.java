import java.util.*;

public class ComparingArray{
    public static void main(String[] args){
        int[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] a2 = new int[9];
        System.out.println(Arrays.equals(a1, a2));
        int[] a3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println(Arrays.equals(a1, a3));
        int[] a4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 5};
        System.out.println(Arrays.equals(a1, a4));
    }
}

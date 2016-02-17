import java.util.*;

public class FillingArray{
    public static void main(String[] args){
        int array[] = new int[6];
        System.out.println("element of the array:");
        for(int i=0; i<6; i++){
            Arrays.fill(array, i);
            System.out.println("array[" + i + "]=" + array[i] + " ");
        }
    }
}

import java.util.*;

public class SearchArray{
    public static void main(String[] args){
        String[] arrStr = {"Rord ChangBai", "Road SiTong", "Road DongSheng", "Road JiLin", "Street ChangChun", "Road YanJi"};
        int location = Arrays.binarySearch(arrStr, "Road DongSheng");
        System.out.println("location of Road DongSheng is " + location + ",arrStr[" + location + "]=" + arrStr[location]);
    }
}

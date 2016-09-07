import java.util.*;

public class SortArray{
    public static void main(String[] args){
        String[] sa = new String[]{"abc", "ABC", "EDF", "234"};
        Arrays.sort(sa, new SingleCompare());
        System.out.println(Arrays.asList(sa));
    }
    public class SingleCompare implements Comparator{
        public int compare(Object o1, Object o2){
            String s1 = (String)o1;
            String s2 = (String)o2;
            return s1.toLowerCase().compareTo(s2.toLowerCase());
        }
    }
}

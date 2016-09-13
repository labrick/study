import java.util.*;

public class LimitClass<T extends List>{
    public static void main(String[] args){
        LimitClass<ArrayList> l1 = new LimitClass<ArrayList>();
        LimitClass<LinkedList> l2 = new LimitClass<LinkedList>();
        //LimitClass<HashMap> l3 = new LimitClass<HashMap>();
    }
}

import java.util.*;

public class AnyClass{
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        for(int i=0; i<a.size(); i++){
            System.out.println("get the value from ArrayList: " + a.get(i));
        }
        Map<Integer, String> m = new HashMap<Integer, String>();
        for(int i=0; i<5; i++){
            m.put(i, "member " + i);
        }
        for(int i=0; i<m.size(); i++){
            System.out.println("get value from Map: " + m.get(i));
        }
        Vector<String> v = new Vector<String>();
        for(int i=0; i<5; i++){
            v.addElement("member " + i);
        }
        for(int i=0; i<v.size(); i++){
            System.out.println("get value from Vector: " + v.get(i));
        }
    }
}

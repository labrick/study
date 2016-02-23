import java.util.*;

public class GetBus{
    public static void main(String[] args){
        Map<String, String> map = new HashMap<String, String>();
        map.put("first station", "Bridge ChangChun");
        map.put("second station", "Street JiLin");
        map.put("third station", "Road LingDong");
        //Set set = map.keySet();
        Collection<String> coll = map.values();
        Iterator<String> it = coll.iterator();
        System.out.println("element of valuse set:");
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}

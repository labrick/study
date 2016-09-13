import java.util.*;

public class MapText{
    public static void main(String[] args){
        Map<String, String> map = new HashMap<String, String>();
        Emp emp = new Emp("001", "ZhangSan");
        Emp emp2 = new Emp("005", "LiSi");
        Emp emp3 = new Emp("004", "WangEr");
        map.put(emp.getE_id(), emp.getE_name());
        map.put(emp2.getE_id(), emp2.getE_name());
        map.put(emp3.getE_id(), emp3.getE_name());
        Set set = map.keySet();
        Iterator it = set.iterator();
        System.out.println("Map set of HashMap achieved, no sorted:");
        while(it.hasNext()){
            String str = (String) it.next();
            String name = (String) map.get(str);
            System.out.println(str + "\t" + name);
        }
        TreeMap treemap = new TreeMap();
        treemap.putAll(map);
        Iterator iter = treemap.keySet().iterator();
        System.out.println("Map set of TreeMap, smallest at the first position:");
        while(iter.hasNext()){
            String str = (String)iter.next();
            String name = (String)map.get(str);
            System.out.println(str + "\t" + name);
        }

    }
}

import java.util.*;

public class MutiOverClass<K, V>{
    public Map<K, V> m = new HashMap<K, V>();
    public void put(K k, V v){
        m.put(k, v);
    }
    public V get(K k){
        return m.get(k);
    }
    public static void main(String[] args){
        MutiOverClass<Integer, String> mu = new MutiOverClass<Integer, String>();
        for(int i=0; i<5; i++){
            mu.put(i, "I am member " + i);
        }
        for(int i=0; i<mu.m.size(); i++){
            System.out.println(mu.get(i));
        }
    }
}

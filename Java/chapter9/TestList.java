import java.util.*;

public class TestList{
    public static void main(String[] args){
        String a = "A", b = "B", c = "C", d = "D", e = "E";
        int i=0;
        List<String> list = new LinkedList<String>();
        list.add(a);
        list.add(e);
        list.add(d);
        Iterator<String> itList = list.iterator();
        System.out.println("element of th List: ");
        i = 0;
        while(itList.hasNext()){
            System.out.println(i++ + "\t" + itList.next());
        }
        System.out.println("////////////////////////////////////set(1, b) and add(2, c)");
        list.set(1, b);
        list.add(2, c);
        Iterator<String> it = list.iterator();
        System.out.println("element of th List after modified: ");
        i = 0;
        while(it.hasNext()){
            System.out.println(i++ + "\t" + it.next());
        }
        System.out.println("////////////////////////////////////indexOf() and lastIndexOf()");
        list.add(a);
        list.add(e);
        list.add(b);
        list.add(e);
        list.add(c);
        list.add(e);
        list.add(d);
        Iterator<String> it2 = list.iterator();
        i = 0;
        while(it2.hasNext()){
            System.out.println(i++ + "\t" + it2.next());
        }
        System.out.println("first location of element \"e\" is " + list.indexOf(e));
        System.out.println("last location of element \"e\" is " + list.lastIndexOf(e));
        System.out.println("first location of element \"b\" is " + list.indexOf(b));
        System.out.println("last location of element \"b\" is " + list.lastIndexOf(b));

        System.out.println("////////////////////////////////////subList(int fromIndex, int toIndex)");
        list = list.subList(1, 3);
        System.out.println("element of subList(1, 3) from list:");
        for(int j=0; j<list.size(); j++){
            System.out.println(list.get(j));
        }
    }
}

import java.util.*;

public class TestCollection{
    public static void main(String[] args){
        System.out.println("//////////////////////////////////////////////////addAll()");
        String apple = "apple";
        String banana = "banana";
        String pear = "pear";
        Collection<String> list = new ArrayList<String>();
        list.add(apple);
        list.add(banana);
        Collection<String> list2 = new ArrayList<String>();
        list2.addAll(list);
        list2.add(pear);
        Iterator<String> it = list2.iterator();
        while(it.hasNext()){
            String str = it.next().toString();
            System.out.println(str);
        }
        System.out.println("//////////////////////////////////////////////////removeAll()");
        String a = "Road ShangHai", b = "Street People", c = "Street ChangChun";
        Collection<String> list3 = new ArrayList<String>();
        list3.add(a);
        list3.add(b);
        Collection<String> list4 = new ArrayList<String>();
        list4.add(b);
        list4.add(c);
        boolean isContains = list3.removeAll(list4);
        System.out.println("hava same element between list3 and list4: " + isContains);
        System.out.println("elements of list3 after executing removeAll: ");
        Iterator<String> ite = list3.iterator();
        while(ite.hasNext()){
            String str = ite.next();
            System.out.println(str);
        }
        System.out.println("//////////////////////////////////////////////////retainAll()");
        //String a = "Road ShangHai", b = "Street People", c = "Street BeiJing";
        Collection<String> list5 = new ArrayList<String>();
        list5.add(a);
        list5.add(b);
        Collection<String> list6 = new ArrayList<String>();
        list6.add(b);
        list6.add(c);
        boolean isContains2 = list5.retainAll(list6);
        System.out.println("hava same element between list3 and list4: " + isContains2);
        System.out.println("elements of list3 after executing retainAll: ");
        Iterator<String> iter = list5.iterator();
        while(iter.hasNext()){
            String str = iter.next();
            System.out.println(str);
        }
        System.out.println("//////////////////////////////////////////////////containsAll()");
        //String a = "Street ChangChun", b = "Street People", c = "Road JieFang";
        Collection<String> list7 = new ArrayList<String>();
        list7.add(a);
        list7.add(b);
        Collection<String> list8 = new ArrayList<String>();
        list8.add(b);
        list8.add(c);
        boolean isContains3 = list7.containsAll(list8);
        System.out.println("list7 include list8?:\n" + isContains3);
        System.out.println("//////////////////////////////////////////////////toArray()");
        String str1 = "Bridge ChangChun", str2 = "Bridge YuanDa", str3 = "Bridge FuRong";
        Collection<String> list9 = new ArrayList<String>();
        list9.add(str1);
        list9.add(str2);
        list9.add(str3);
        Object[] strs2 = list9.toArray();   // Object[] ????
        for(int i=0; i<strs2.length; i++){
            System.out.println(strs2[i]);
        }
    }
}

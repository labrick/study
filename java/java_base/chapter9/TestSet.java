import java.util.*;

public class TestSet{
    public static void main(String[] args){
        Person person1 = new Person("Mr. Ma", 220181);
        Person person2 = new Person("Mr. Jiang", 220182);
        Person person3 = new Person("Mr. Kang", 220183);
        Person person4 = new Person("Mr. Zheng", 220184);
        Person person5 = new Person("Miss Wang", 220185);
        //Set<Person> hashSet = new HashSet<Person>();
        //hashSet.add(person1);
        //hashSet.add(person2);
        //hashSet.add(person3);
        //hashSet.add(person4);
        //hashSet.add(person5);
        //Iterator<Person> it = hashSet.iterator();
        //while(it.hasNext()){
        //    Person person = it.next();
        //    System.out.println(person.getName() + "\t" + person.getId_card());
        //}

        //////////////////////////////////
        

        TreeSet<Person> treeSet = new TreeSet<Person>();
        //treeSet.add(person1);
        //treeSet.add(person2);
        //treeSet.add(person3);
        //treeSet.add(person4);
        //treeSet.add(person5);
        //System.out.println("the treeset after init:");
        //Iterator<Person> ite = treeSet.iterator();
        //while(ite.hasNext()){
        //    Person person = ite.next();
        //    System.out.println("----" + person.getId_card() + "\t" + person.getName());
        //}
        //System.out.println("the treeset after subset before toElement:");
        //ite = treeSet.headSet(person1).iterator();
        //while(ite.hasNext()){
        //    Person person = ite.next();
        //    System.out.println("----" + person.getId_card() + "\t" + person.getName());
        //}
        //System.out.println("the treeset after subset between fromElement and toElement:");
        //ite = treeSet.subSet(person1, person3).iterator();
        //while(ite.hasNext()){
        //    Person person = ite.next();
        //    System.out.println("----" + person.getId_card() + "\t" + person.getName());
        //}
        //System.out.println("the treeset after subset after fromElement:");
        //ite = treeSet.tailSet(person3).iterator();
        //while(ite.hasNext()){
        //    Person person = ite.next();
        //    System.out.println("----" + person.getId_card() + "\t" + person.getName());
        //}
    }
}

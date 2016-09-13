public class Test{
    public static void main(String[] args){
        final int NUM = 100;    //const num
        int age;
        char char1 = 'r';
    }
    private String name = null;
    public void NameIsNull(){
        // 注意&&和&的区别，下面的可以增加安全性
        // 因为采用&&如果name=null，name.equals就不会再执行
        // name没有对象，调用equals就会出错
        if((name != null) && !name.equals(""))
            System.out.println("name:" + name);
        else
            System.out.println("please input the name!");
    }
}

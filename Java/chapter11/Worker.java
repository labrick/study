import java.io.*;

// this Serializable is java.io.Serializable**************
public class Worker implements java.io.Serializable{
    public String name;
    public String sex;
    public int age;
    private static final long serialVersionUID = 1L;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
}

public class Animal{
    public boolean live = true;
    public String skin = "";

    public Animal(){
    }
    public Animal(String strSkin){
        skin = strSkin;
    }

    public void eat(){
        System.out.println("Animal need eat some food");
    }
    public void move(){
        System.out.println("Animal can move");
    }
}

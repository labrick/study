public class ArrayClass<T>{
    private T[] array;
    public void setT(T[] array){
        this.array = array;
    }
    public T[] getT(){
        return array;
    }
    public static void main(String[] args){
        ArrayClass<String> a = new ArrayClass<String>();
        String[] array = { "member 1", "member 2", "member 3", "member 4", "member 5"};
        a.setT(array);
        for(int i=0; i<a.getT().length; i++){
            System.out.println(a.getT()[i]);
        }
    }
}

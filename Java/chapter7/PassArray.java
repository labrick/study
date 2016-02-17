public class PassArray{
    public static void modifyArray(int array[]){
        for(int i=0; i<array.length; i++){
            array[i] *= 2;
        }
    }
    public static void main(String[] args){
        int array[] = {1, 2, 3, 4, 5};
        System.out.println("original array: ");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + "\t");
        }
        System.out.println();
        modifyArray(array);
        System.out.println("array after modify by modifyArray: ");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}

public class CopyArray{
    public static void main(String[] args){
        int i;
        int arr1[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int arr2[] = new int[10];
        String[] s = new String[]{"abc", "ABC", "EDF", "234"};
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        System.out.println("arr2 after copying:");
        for(i=0; i<arr2.length; i++){
            System.out.print(arr2[i] + ",");
        }
        System.out.println();
    }
}

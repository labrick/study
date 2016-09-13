public class Test{
    public static void main(String[] args){
        int[] a1 = {1, 2, 3, 4, 5, 6};
        int[] a2;       // error if in C/C++, here = define a pointer
        ///////////////
        int[] array1 = new int[6];
        int[] array2 = new int[]{1, 2, 3, 4, 5};
        ///////////////
        a2 = a1;
        for(int i=0; i<a1.length; i++){
            a2[i]++;
            System.out.print("a1[" + i + "]=" + a1[i] + "\t");
            System.out.println("a2[" + i + "]=" + a2[i]);
        }
    }
}

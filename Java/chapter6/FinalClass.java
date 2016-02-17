final class FinalClass{
    int a = 3;
    void doit(){}
    public static void main(String[] args){
        FinalClass f = new FinalClass();        // 这里很有代表性，貌似递归而实际并没有递归起来
        f.a++;
        System.out.println(f.a);
    }
}

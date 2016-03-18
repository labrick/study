public class CopyOfEnumIndexTest{
    enum Constants2{
        Constants_A("I am ConstantsA of enum!"),
        Constants_B("I am ConstantsB of enum!"),
        Constants_C("I am ConstantsC of enum!"),
        Constants_D(3);

        private String description;
        private int i = 4;
        private Constants2(){
        }
        private Constants2(String description){
            this.description = description;
        }
        private Constants2(int i){
            this.i = this.i + i;
        }
        public String getDescription(){
            return description;
        }
        public int getI(){
            return i;
        }
    }
    public static void main(String[] args){
        for(int i=0; i<Constants2.values().length; i++){
            System.out.println(Constants2.values()[i] + "call getDescription() method: " + Constants2.values()[i].getDescription());
        }
        System.out.println(Constants2.Constants_D + "call getI() method: " + Constants2.Constants_D.getI());
    }
}

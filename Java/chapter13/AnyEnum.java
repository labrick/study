interface d{
    public String getDescription();
    public int getI();
}
public enum AnyEnum implements d{
    Constants_A{
        public String getDescription(){
            return ("I am Constants_A of enum!");
        }
        public int getI(){
            return i;
        }
    },
    Constants_B{
        public String getDescription(){
            return ("I am Constants_B of enum!");
        }
        public int getI(){
            return i;
        }
    },
    Constants_C{
        public String getDescription(){
            return ("I am Constants_C of enum!");
        }
        public int getI(){
            return i;
        }
    },
    Constants_D{
        public String getDescription(){
            return ("I am Constants_D of enum!");
        }
        public int getI(){
            return i;
        }
    };
    private static int i = 5;
    public static void main(String[] args){
        for(int i=0; i<AnyEnum.values().length; i++){
            System.out.println(AnyEnum.values()[i] + " call getDescription() mothed: " + AnyEnum.values()[i].getDescription());
            System.out.println(AnyEnum.values()[i] + " call getI() mothed: " + AnyEnum.values()[i].getI());
        }
    }
}

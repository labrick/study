public class StrSplit{
    public static void main(String[] args){
        String str = "company name: yan technical! company site: Wuxi Jiangsu. company tel: 13167725325";
        String[] info = null;
        info = str.split("\\.|!");          // use \\. replace .; use \\| replace |
        for(int i=0; i<info.length; i++){
            System.out.println(info[i].trim());
        }
    }
}

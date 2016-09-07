public class ByteArray{
    public static void main(String[] args){
        byte[] byteArray = new byte[]{65, 66, 67};
        String str = new String(byteArray);
        // note difference:
        // String()
        // String(byte[] bytes)
        // String(byte[] bytes, String charsetName)
        // String(char[] value)
        // String(StringBuffer buffer)
        // String(StringBuilder builder)
        System.out.println(str);
    }
}

package Java.String;

public class CreateNumber {
    public void generate(long value){
        // String s = "9".repeat((int)value);
        System.out.println(String.valueOf(value).length());
    }
    public static void main(String[] args) {
        CreateNumber number = new CreateNumber();
        long n = (long)Math.pow(10, 15);
        number.generate(n);
    }
}

package Java.CodeTrix;

public class ListToArray{
    public static void main(String[] args) {
        StringBuilder b = new StringBuilder("1Q21");
        
        System.out.println(b.toString().replaceAll("[0-9]", "."));
    }
}
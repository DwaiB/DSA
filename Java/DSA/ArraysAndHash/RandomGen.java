package Java.DSA.ArraysAndHash;

public class RandomGen {
    public String generate(String s){
        byte[] b = s.getBytes();
        s = b[1]+ b.toString().substring(2);
        return s;
    }
    public static void main(String[] args) {
        RandomGen gen = new RandomGen();
        System.out.println(gen.generate("fef"));
        Map<int,int> map = new HashMap<>();
    }
}

public class countDigitOnes {
    public static int countDigitOne(int n) {
        if(n == 0 ){
            return 0;
        }
        int count = 0;
        for(int i = 1; i <= n; i++){
            String s = String.valueOf(i);
            count+= s.chars().filter(e -> e =='1').count();
            
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countDigitOne(13));
    }
}

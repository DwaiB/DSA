class CountGoodNumbers {
    
   public int countGoodNumbers(long n) {
        String size="";
        for(long i = 1; i <= n;i++){
            size = size + 9;
        }
        System.out.println("Size=> "+size);
        int count = 0, M = 1000000007;
        for(long i = 0; i <= 2; i++){
            if(checkGoodNumber(String.valueOf(i))){
                count = (count + 1)%M;
            }
        }
        return count;
    }
    public long checkGood(String size){
        if(size.equals("0")){
            return 1;
        }
        long count = (checkGoodNumber(size))?1:0;
        return (count + checkGood(prevNum(size)))%1000000007;
    }
    public String prevNum(String size){
        StringBuilder sb  = new StringBuilder(size);
        int dig = sb.charAt(sb.length());
        
        if(--dig == -1){
            while(dig != -1){

            }
        }
        return sb.toString();
    }
    public boolean checkGoodNumber(String n){
        long d,idx=1;
        while(n.length() > 0){
            d = Long.parseLong(String.valueOf(n.charAt(0)));
            n = n.substring(1);
            if(idx%2 == 0 && d%2 != 0){
                return false;
            }
            if(idx%2 != 0 && !isPrime(d)){
                return false;
            }
            idx--;
        }
        return true;
    }
    public boolean isPrime(long digit){
        if(digit == 0  || digit  == 1 || digit == 2 || digit == 3 || digit == 5 || digit == 7){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        CountGoodNumbers cg = new CountGoodNumbers() ;
        System.out.println(cg.countGoodNumbers(1));
    }
}
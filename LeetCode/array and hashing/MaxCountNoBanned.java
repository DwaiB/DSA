package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class MaxCountNoBanned {
    public int maxCount(int[] banned, int n, int maxSum) {
        int s = 0,c = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : banned) {
            set.add(i);
        }
        for(int i =1;i<=n;i++){
            if(set.contains(i)== true){
                if((s+i)<=maxSum){
                    s+=i;
                    c++;
                }
                else return c;
            }
        }
        return c;
    }
    public boolean check(int[] banned, int num){
        for( int i: banned){
            if(i==num){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        MaxCountNoBanned mx = new MaxCountNoBanned();
        int [] banned = {1,6,5};
        int n = 5, maxSum = 6;
        int res = mx.maxCount(banned,n,maxSum);
        List<Integer> result = Arrays.stream(banned).boxed().collect(Collectors.toList());
        result.forEach(System.out::print);
        System.out.println(" "+n+" "+maxSum);
        System.out.println(res);
    }
}

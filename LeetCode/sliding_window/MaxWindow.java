import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.SortedMap;
import java.util.TreeMap;

public class MaxWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 1 ) return nums;
        int max = 0,smax = 0,left = 0,right = k,idx = 0; 
        int [] res = new int[n-k+1];
        SortedMap<Integer,Integer> smap = new TreeMap<>();
        if(right > n){
            right = n;
        }
        while (left < right){
            smap.put(nums[left], smap.getOrDefault(nums[left], 0)+1);
        }
        res[idx++] = smap.lastKey();
        return res;
    }
    public static void main(String[] args) {
        
    }
}

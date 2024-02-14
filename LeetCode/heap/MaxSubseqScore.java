package LeetCode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;


public class MaxSubseqScore {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int [] nums1 = {4,2,3,1,1};
        int [] nums2 = {7,5,10,9,6};
        int k = 1;
        System.out.println("MAX SCORE: " + solution.maxScore(nums1,nums2,k));
    }   
}
class Solution1 {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] arr = new int[nums1.length][2];
        for(int i=0;i<nums1.length;++i){
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
        }
        Arrays.sort(arr,(a,b) -> a[1] == b[1]? Integer.compare(b[0],a[0]): Integer.compare(b[1], a[1]));
        PriorityQueue<int[]> maxh = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        long sum = 0, min = Integer.MAX_VALUE,res=0;
        for(int i=0;i<k;++i){
            sum += arr[i][0];
            min = Math.min(min,arr[i][1]);
            maxh.offer(arr[i]);
        }
        res = Math.max(res,sum*min);
        for(int i = k;i < arr.length;++i){
            if(maxh.peek()[0] < arr[i][0]){
                if(min == maxh.peek()[1]){
                    min = arr[i][1];
                }
                sum -= maxh.poll()[0];
                min = Math.min(min,arr[i][1]);
                sum += arr[i][0];
                maxh.offer(arr[i]);
            }
            res = Math.max(res,sum*min);
        }
        
        return res;
    }
}
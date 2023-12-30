package LeetCode.heap;

import java.util.PriorityQueue;

public class MinDeviationArray {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 1, 3, 5, 2, 8 };
        int res = s.minimumDeviation(nums);
        System.out.println("MinDeviation: " + res);
        
    }
}

class Solution {
    class Pair implements Comparable<Pair>{
        int i;
        public Pair(int i){
            this.i = i;
        }
        @Override
        public int compareTo(Pair o) {
            return this.i > o.i ? -1 : 1;
        }
        
    }
    public int minimumDeviation(int[] nums) {
        Pair p1 = new Pair(4);
        Pair p2 = new Pair(2);
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        pq.add(p2);
        pq.add(p1);
        p1.i = 1;
        pq.remove(p1);
        pq.offer(p1);
        while(pq.size()>0){
            System.out.println("Value: "+pq.poll().i);
        }
        return 0;
    }
}
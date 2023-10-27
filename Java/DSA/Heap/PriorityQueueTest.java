package Java.DSA.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PriorityQueueTest  {
    class Pair implements Comparable<Pair>{
        public int f,i;
        public Pair(int i,int f){
            this.i = i;
            this.f = f;
        }
        @Override
        public int compareTo(Pair o) {
            return (this.f < o.f)? 1 : 0;
        }
        
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        int n = nums.length,idx = -1;

        for(int i=0;i<n;i++){
            map.putIfAbsent(nums[i],0);
            int fr = map.get(nums[i]);
            map.put(nums[i],fr+1);
        }
        for(Integer i : map.keySet()){
            int freq = map.get(i);
            if(heap.size() == k){
                if(heap.peek().f < freq){
                    heap.poll();
                    heap.add(new Pair(i,freq));
                }
            }else{
                heap.add(new Pair(i,freq));
            }
        }
        int[] ans = new int[k];
        while(!heap.isEmpty()){
            ans[++idx] = heap.poll().i;
        }
        return ans;
    }
}

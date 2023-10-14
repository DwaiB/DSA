package Java.DSA.GraphsExt;

import java.util.Iterator;
import java.util.PriorityQueue;

import Java.DSA.Utils.Pair;

public class PrimsAlgo {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length,eval,connected =0,i=0;
        boolean [] visited = new boolean[n];

        PriorityQueue<Pair<Integer,Integer>> queue = new PriorityQueue<>((a,b) -> a.getKey() - b.getKey());
        
        int res = 0;
        while(++connected < n){
            visited[i] = true;
            for(int j = 0; j <n;j++){
                if(!visited[j]){
                    eval = calc(points, i, j);
                    queue.add(new Pair<>(eval,j));
                }
            }
            while(visited[queue.peek().getValue()]){
                queue.poll();
            }
            print(queue);
            res += queue.peek().getKey();
            i = queue.poll().getValue();
            
        }
        return res;
    }
    public void print(PriorityQueue<Pair<Integer,Integer>> queue) {
        System.out.println("Queue");
        Iterator<Pair<Integer,Integer>> itr = queue.iterator();
        while(itr.hasNext()){
            Pair<Integer,Integer> p = itr.next();
            System.out.println(p);
        }
    }
    public int calc(int[][] points, int i,int j){
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }
    public static void main(String[] args) {
        MinCostConAllPoints Solution = new MinCostConAllPoints();
        int [][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println("Total "+Solution.minCostConnectPoints(points));

    }
}

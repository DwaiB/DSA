package Java.DSA.GraphsExt;

import java.util.PriorityQueue;

public class PrimsAlgo {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length,eval,connected =0,i=0;
        boolean [] visited = new boolean[n];

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        for(int u = 0;u<n;u++){
            for(int v = u+1; v<n ;v++){ 
                if(u == v) continue;
                int [] edge = new int[3];
                eval = calc(points, u, v);
                edge[0] = u;
                edge[1] = v;
                edge[2] = eval;
                queue.add(edge);
            }
        }
        int res =0;
        while(++connected < n){
            visited[i] = true;
            for(int j = 0; j <n;j++){
                if(!visited[j]){
                    int [] edge = new int[2];
                    eval = calc(points, i, j);
                    edge[0] = j;
                    edge[1] = eval;
                    queue.add(edge);
                }
            }
            while(visited[queue.peek()[0]]){
                queue.poll();
            }
            res += queue.peek()[1];
            i = queue.poll()[0];
            
        }
        return res;
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

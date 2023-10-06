package Java.DSA.GraphsExt;

import java.util.Arrays;

public class MinCostConAllPoints {
    //Kruskal's Algorithm
    int [] parent;
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int  [][] edges = new int[n*(n-1)/2][3];
        parent = new int[n+1];
        int total =0,eval,k=-1,pU,pV;
        for(int u = 0;u<n;u++){
            parent[u] = u; 
            for(int v = u+1; v<n ;v++){ 
                if(u == v) continue;
                eval = calc(points, u, v);
                ++k;
                edges[k][0] = u;
                edges[k][1] = v;
                edges[k][2] = eval;
            }
        }
        Arrays.sort(edges,(a,b) -> a[2] - b[2]);
        for(int i=0;i<=k;++i){
            pU = find(edges[i][0]);
            pV = find(edges[i][1]);
            if(pU != pV){
                total += edges[i][2];
                parent[pU] = pV;
            }
        }
        return total;
    }    
    public int calc(int[][] points, int i,int j){
        
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }
    public int find(int x){
        if(parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    public static void main(String[] args) {
        MinCostConAllPoints Solution = new MinCostConAllPoints();
        int [][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println("Total "+Solution.minCostConnectPoints(points));

    }
}

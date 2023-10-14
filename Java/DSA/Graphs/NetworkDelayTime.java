package Java.DSA.Graphs;

import java.util.Arrays;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int min = -1,size = times.length;
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;
        for(int i=1;i<n;i++){
            for(int j=0;j<size;j++){
                int u = times[j][0];
                int v = times[j][1];
                int w = times[j][2];
                if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            min = Math.max(min,dist[i]);
        }
        return min;
    }
}

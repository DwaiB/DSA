package LeetCode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwimInWater {

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        Map<Integer,List<Integer>> graph = new HashMap<Integer,List<Integer>>();
        List<Integer> vertex;
        boolean[][] visited = new boolean[n][n];
        for(int i=0;i<n;++i){
            vertex = new ArrayList<Integer>();
            for(int j=0;j<n;++j){
                
                if(i>0){
                    vertex.add(grid[i-1][j]);
                }
                if(j>0){
                    vertex.add(grid[i][j-1]);
                }
                if(i<n-1){
                    vertex.add(grid[i+1][j]);
                }
                if(j<n-1){
                    vertex.add(grid[i][j+1]);
                }
                visited[i][j] = false;
                graph.put(grid[i][j],vertex);            
            }
        }
        
        return getMinTime(n,grid,graph,0,0,0,grid[n-1][n-1],visited);

        }
    }
    

    private int getMinTime(int n,int[][]grid, Map<Integer,List<Integer>> graph,int i,int j, int t, int target,boolean[][] visited){
        if(visited[i][j]){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        List<Integer> edges = graph.get(grid[i][j]);
        visited[i][j] = true;
        int path;
        for(Integer edge : edges){
            path = getMinTime(n, grid, graph, min, j, path, target, visited); 
        }
        visited[i][j] = false;
        return min == Integer.MAX_VALUE ? -1 : min;
    }


    public static void main(String[] args) {
        SwimInWater swim = new SwimInWater();

    }
}

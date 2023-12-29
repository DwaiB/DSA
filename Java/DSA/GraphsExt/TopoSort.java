package Java.DSA.GraphsExt;


import java.util.ArrayList;
import java.util.List;

public class TopoSort {
    public List<Integer> sort(int[][] edges){
        List<Integer> arr_list = new ArrayList<>();
        int[] indeg = new int[edges.length];
        int size = -1;
        for(int i = 0; i < edges.length; ++i){
            int u = edges[i][0];
            int v = edges[i][1];
            ++indeg[v];
        }
        return arr_list;
    }
}

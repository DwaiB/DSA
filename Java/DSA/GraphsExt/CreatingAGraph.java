package Java.DSA.GraphsExt;

import java.util.Arrays;

public class CreatingAGraph {

    public void create(int size,int[][] edges){
        int[] key = new int[size];
        Arrays.fill(key,-1);
        
        for(int i = 0; i < edges.length;++i){
            int u = edges[i][0];
            if(key[u] == -1){
                key[u] = i;
            }else{
                int k = key[u];
                while(edges[k][0] != size){
                    ++k;
                }
                edges[k][0] = i;
            }    
            edges[i][0] = size;
        }
    }
    public static void main(String[] args) {
        
    }
}

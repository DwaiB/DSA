import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountApples {
    class Node{
        public int val;
        public boolean hasApple;
        public List<Integer> edges;
        public Node(int val){
            this.val = val;
            this.edges = new ArrayList<Integer>();
        }
        public void add(int i){
            edges.add(i);
        }
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Node[] nodes = new Node[n];
        for(int i = 0; i < n; ++i){
            nodes[i] = new Node(i);
            if(hasApple.get(hasApple.indexOf(i))){
                nodes[i].hasApple = true;
            }
        }
        for(int[] e : edges){
            nodes[e[0]].add(e[1]);
            nodes[e[1]].add(e[0]);
        }
        int ans = 0;
        int[] visited = new int[n];
        Arrays.fill(visited,1);
        visited[0]= 2;
        if(nodes[0].hasApple) ans = 1;
        for(Integer i : nodes[0].edges){
            ans += eatApples(i,nodes,visited);
        }
        return ans;
    }
    public int eatApples(Integer i,Node[] nodes, int[] visited) {
        if(visited[i] != 1){
            return 0;
        }
        int count = 0;
        if(nodes[i].hasApple){
            count = 1;
        }
        visited[i] = 2;
        for(Integer e : nodes[i].edges){
            count = count + eatApples(e, nodes, visited);
        }
        visited[i] = 3;
        return count;
    }
}

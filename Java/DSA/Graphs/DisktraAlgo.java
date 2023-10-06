package Java.DSA.Graphs;

import java.util.ArrayList;
import java.util.List;

public class DisktraAlgo {
    public int shortestPath(Node<String> node1,Node<String> node2){
        List<Node<String>> visited = new ArrayList<>();
        return dfs(node1,node2,visited);
    }
    public int dfs(Node<String> node1,Node<String> node2,List<Node<String>> visited){
        if(node1 == null || node2 == null || visited.contains(node1)){
            return -1;
        }
        int min = Integer.MAX_VALUE, path = 0;
        if(node1.equals(node2)){
            return 0;
        }
        for(Node<String> i : node1.neighbors.keySet()){
            visited.add(node1);
            path = dfs(i,node2,visited);
            visited.remove(visited.size()-1);
            if(path == -1) continue;
            min = Math.min(min, path+node1.neighbors.get(i));
        }
        return (min == Integer.MAX_VALUE)? -1 : min;
    }

    public static void main(String[] args) {
        DisktraAlgo algo = new DisktraAlgo();
        Node<String> A = new Node<>("A");
        Node<String> B = new Node<>("B");
        Node<String> C = new Node<>("C");
        Node<String> D = new Node<>("D");
        Node<String> E = new Node<>("E");
        Node<String> F = new Node<>("F");

        A.addNeighbor(B,2);
        A.addNeighbor(C,2);
        B.addNeighbor(B,3);
        B.addNeighbor(D,4);
        B.addNeighbor(E,2);
        C.addNeighbor(E,3);
        D.addNeighbor(F,1);
        E.addNeighbor(D,1);
        E.addNeighbor(F,2);
        System.out.println("Shortest Distance from "+A.val+" to "+F.val+" = "+algo.shortestPath(A, F));
    }
}

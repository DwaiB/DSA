package Java.DSA.Graphs;

import java.util.LinkedList;

public class Edge {
    private LinkedList<Integer> adj;
    public Edge() {
        this.adj = new LinkedList<Integer>();
    }
    public int size(){
        return adj.size();
    }
    public int contains(int V){
        return adj.indexOf(V);
    }
    public int valueAt(int V){
        return this.adj.get(V);
    }
    public boolean add(int V){
        if(contains(V) != -1){
            return false;
        }else{
            this.adj.add(V);
            return true;
        }
    }
    public boolean remove(int V){
        if(contains(V) == -1){
            return false;
        }else{
            this.adj.remove(contains(V));
            return true;
        }
    }
}

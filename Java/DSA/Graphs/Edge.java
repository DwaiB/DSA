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
    public int indexOf(int V){
        return adj.indexOf(V);
    }
    public int valueAt(int V){
        return this.adj.get(V);
    }
    public boolean add(int V){
        if(indexOf(V) != -1){
            return false;
        }else{
            this.adj.add(V);
            return true;
        }
    }
    public boolean remove(int V){
        if(indexOf(V) == -1){
            return false;
        }else{
            this.adj.remove(indexOf(V));
            return true;
        }
    }

    public LinkedList<Integer> getAll(){
        return adj;
    }
}

package Java.DSA.Graphs;

public interface Graph<T> {

    public T[] NODES();

    public Edge EDGES(T a);

    public int FIND(T a);

    public T INDEX(int V);

    public int SIZE();
    
    public boolean DELETE(T a);

    public int FINDEDGE(T a, T b);

    public boolean INSNODE(T a);

    public boolean INSEDGE(T a, T b);

    public boolean DELNODE(T a);

    public boolean DELEDGE(T a, T b);

    public int INDEGREE(T a);

    public boolean BFS(T a, T b);

    public boolean DFS(T a, T b);
}

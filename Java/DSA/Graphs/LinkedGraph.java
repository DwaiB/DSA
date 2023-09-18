package Java.DSA.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedGraph<T> implements Graph<T>{

    private int V,SIZE,START,AVAIL;
    private Edge[] ADJ;
    private int[] NEXT;
    private Object[] NODES;
    public LinkedGraph(int S){
        this.V = S;
        this.SIZE = 0;
        this.START = -1;
        this.AVAIL = 0;
        this.ADJ = new Edge[V];
        this.NEXT = new int[V];
        this.NODES = new Object[V];
        INIT();
    }
    public void INIT(){
        for(int i = 0 ;i < V;i++){
            this.ADJ[i] = new Edge();
            this.NEXT[i] = i+1;
        }
        this.NEXT[V-1] = -1;
    }
    @SuppressWarnings("unchecked")
    public boolean COMP(T a, Object b){
        T element = (T) b;
        if(element instanceof String){
            return a.equals(b);
        }else{
            return a == b;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] NODES(){
        return (T[]) NODES;
    }

    @Override
    public Edge EDGES(T a){
        int loc = FIND(a);
        Edge e = ADJ[loc];
        return e;
    }
    @Override
    public int FIND(T a) {
        int ptr = START,loc = -1;
        while(ptr != -1){
            if(COMP(a,NODES[ptr])){
                loc = ptr;
                break;
            }
            ptr = NEXT[ptr];
        }
        return loc;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T INDEX(int V){
        return (T) NODES[V];
    }
    @Override
    public boolean DELETE(T a) {
        if(START == -1){
            return false;
        }
        int ptr,save;
        if(COMP(a,NODES[START])){
            ptr = START;
            START = NEXT[START];
            NEXT[ptr] = AVAIL;
            AVAIL = ptr;
            return true;
        }
        ptr = NEXT[START];
        save = START;
        while(ptr != -1){
            if(COMP(a,NODES[ptr])){
                NEXT[save] = NEXT[ptr];
                NEXT[ptr] = AVAIL;
                AVAIL = ptr;
                return true;
            }
            save = ptr;
            ptr  = NEXT[ptr];
        }
        return false;
    }
    @Override
    public int FINDEDGE(T a, T b) {
        int loc = -1;
        int locA = FIND(a);
        int locB = FIND(b);
        if(locA == -1 || locB == -1){
            return loc;
        }
        loc = ADJ[locA].indexOf(locB);
        return loc;
    }
    @Override
    public boolean INSNODE(T a) {
        if(AVAIL == -1){
            return false;
        }
        ADJ[AVAIL] = new Edge();
        int curr = AVAIL;
        AVAIL = NEXT[AVAIL];
        NODES[curr] = a;
        NEXT[curr] = START;
        START = curr;
        SIZE++;
        return true;
    }
    @Override
    public boolean INSEDGE(T a, T b) {
        int locA = FIND(a);
        int locB = FIND(b);
        return ADJ[locA].add(locB);
    }
    @Override
    @SuppressWarnings("unchecked")
    public boolean DELNODE(T a) {
        int loc = FIND(a);
        if(loc == -1){
            return false;
        }
        int ptr = START;
        while(ptr != -1){
            DELEDGE((T) NODES[ptr], a);
            ptr = NEXT[ptr];
        }
        ADJ[loc] = new Edge();
        DELETE(a);
        SIZE--;
        return true;
    }
    @Override
    public boolean DELEDGE(T a, T b) {
        int locA = FIND(a);
        int locB = FIND(b);
        return ADJ[locA].remove(locB);
    }

    @Override
    public int SIZE(){
        return SIZE;
    }
    
    @Override
    public int INDEGREE(T a){
        int loc = FIND(a);
        int count = 0;
        for(int i = 0; i < SIZE;i++){
            if(i == loc) continue;
            Edge e = ADJ[i];
            for(int j = 0;j<e.size();j++){
                if(e.valueAt(j) == loc){
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public boolean BFS(T a, T b){
        int[] visited = new int[SIZE];
        Arrays.fill(visited,1); // READY
        Queue<Integer> queue = new LinkedList<>();   
        int loc = FIND(a);
        int locB = FIND(b);
        if(loc == -1 || locB == -1)
        return false;
        queue.add(loc);
        visited[loc] = 2; // WAIT
        while(!queue.isEmpty()){
            int poll = queue.poll();
            visited[poll] = 3; // PROCESSED
            if(poll == locB){
                return true;
            }
            Edge e = ADJ[poll];
            for(int i = 0; i < e.size();i++){
                int j = e.valueAt(i);
                if(visited[j] == 1){
                    visited[j] = 2;
                    queue.add(j);
                }
            }
        }
        return false;
    }
    @Override
    public boolean DFS(T a, T b){
        int[] visited = new int[SIZE];
        Arrays.fill(visited,1);
        int locA = FIND(a);
        int locB = FIND(b);
        System.out.println("Route ");
        boolean flag = DFSEARCH(locA,locB,visited);
        System.out.println();
        return flag;
    }

    public boolean DFSEARCH(int curr, int loc,int [] visited){
        if(curr == -1){
            return false;
        }
        System.out.print(String.valueOf(NODES[curr])+"->");
        if(curr == loc){
            return true;
        }
        if(visited[curr] == 3){
            return false;
        }
        visited[curr] = 3;
        Edge e = ADJ[curr];
        boolean flag = false;
        int ptr;
        for(int i = 0; i < e.size();i++){
            ptr = e.valueAt(i);
            if(visited[ptr] == 1){
                visited[ptr] = 2;
                flag  |= DFSEARCH(e.valueAt(i), loc, visited);
            }
            if(flag) break;
        }
        return flag;
    }
}
package Java.DSA.Graphs;


public class TopologicalSort<T> {
    @SuppressWarnings("unchecked")
    public void Sort(Graph<T> gh){
        T[] nodes = gh.NODES();
        int[] ig = new int[nodes.length];
        T [] queue = (T[]) new Object[nodes.length];

        int start = 0, rear=-1;
        System.out.println("Topological Sort");
        for(int i =0; i < nodes.length;i++){
            
            ig[i] = gh.INDEGREE(nodes[i]);
            if(ig[i] == 0){
                System.out.println("Adding "+String.valueOf(nodes[i]));
                rear++;
                queue[rear] = nodes[i];
            }
        }
        System.out.println();
        while(start < rear){
            T polled = queue[start];
            Edge e = gh.EDGES(polled);
            for(int i = 0; i < e.size();i++){
                int k = e.valueAt(i);
                ig[k] --;
                if(ig[k] == 0){
                    System.out.println("Insert" + String.valueOf(nodes[k]));
                    rear++;
                    queue[rear] = nodes[k];
                    
                }
            }
            start++;
        }
        start=0;
        while(start <= rear){
            System.out.print(String.valueOf(queue[start]+" "));
            start++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph<Character> graph = new LinkedGraph<>(7);
        graph.INSNODE('A');
        graph.INSNODE('B');
        graph.INSNODE('C');
        graph.INSNODE('D');
        graph.INSNODE('E');
        graph.INSNODE('F');
        graph.INSNODE('G');
        graph.INSEDGE('A', 'C');
        graph.INSEDGE('B', 'D');
        graph.INSEDGE('B', 'F');
        graph.INSEDGE('D', 'C');
        graph.INSEDGE('E', 'C');
        graph.INSEDGE('G', 'A');
        graph.INSEDGE('G', 'F');
        System.out.println(graph.INDEGREE('C'));
        TopologicalSort<Character> sort = new TopologicalSort<>();
        sort.Sort(graph);
    }
}

package Java.DSA.GraphsExt;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class graphHead{
    public int count;
    public graphVertex first;
}
class graphVertex{
    public graphVertex next;
    public int data;
    public int inDegree;
    public int outDegree;
    public boolean inTree;
    public graphEdge firstEdge;
    public graphVertex(int data){
        this.data = data;
        inDegree = 0;
        outDegree = 0;
        next = null;
        firstEdge = null;
    }
}
class graphEdge{
    public graphVertex destination;
    public int weight;
    public graphEdge nextEdge;
    public boolean inTree;
    public graphEdge(graphVertex destination,int weight){
        this.destination = destination;
        this.weight = weight;
        this.destination.inDegree++;
        this.nextEdge = null;
    }
}

public class MinSpanTree {
    public graphHead minSpan(graphHead node){
        if(node == null){
            return null;
        }
        
        graphVertex vertex = node.first;
        graphEdge edge,minEdgeLoc;
        boolean treeComplete;
        while(vertex != null){
            vertex.inTree = false;
            edge = vertex.firstEdge;
            while(edge != null){
                edge.inTree = false;
                edge = edge.nextEdge;
            }
            vertex = vertex.next;
        }
        node.first.inTree = true;
        treeComplete = false;
        boolean [] visited = new boolean[7];

        while(!treeComplete){
            treeComplete = true;
            int minEdge = Integer.MAX_VALUE;
            minEdgeLoc = null;
            vertex =  node.first;
            while(vertex != null){
                if(vertex.inTree && vertex.outDegree > 0 && !visited[vertex.data]){
                    edge = vertex.firstEdge;
                    while(edge != null){
                        if(!edge.destination.inTree){
                            edge.destination.inTree = false;
                            treeComplete = false;
                        }
                        if(edge.weight < minEdge){
                            minEdge = edge.weight;
                            minEdgeLoc = edge;
                        }
                        edge = edge.nextEdge;
                    }
                }
                visited[vertex.data] = true;
                vertex = vertex.next;
            }
            if(minEdgeLoc != null){
                minEdgeLoc.inTree = true;
                minEdgeLoc.destination.inTree = true;
            }
            Arrays.fill(visited,false);
        }
        return node;
    }

    public static void main(String[] args) {
        MinSpanTree MST = new MinSpanTree();

        graphHead head = new graphHead();
        graphVertex A = new graphVertex(1);
        head.first = A;
        graphVertex B = new graphVertex(2);
        A.next = B;
        graphVertex C = new graphVertex(3);
        B.next = C;
        graphVertex D = new graphVertex(4);
        C.next = D;
        graphVertex E = new graphVertex(5);
        D.next  = E;
        graphVertex F = new graphVertex(6);
        E.next = F;
        head.count = 6;
        graphEdge e = new graphEdge(B,6);
        e.nextEdge = new graphEdge(C,3);
        A.firstEdge = e;
        
        A.outDegree = 2;

        e = new graphEdge(C,2);
        e.nextEdge = new graphEdge(D,5);
        B.firstEdge = e;
        
        B.outDegree = 3;

        e = new graphEdge(D,3);
        e.nextEdge = new graphEdge(E,4);
        C.firstEdge = e;
        C.outDegree = 3;

        e = new graphEdge(E,2);
        e.nextEdge = new graphEdge(F,3);
        D.firstEdge = e;
        D.outDegree = 3;

        e =  new graphEdge(F, 5);
        E.firstEdge = e;
        E.outDegree = 3;

        MST.print(head);
        graphHead node = MST.minSpan(head);
        graphVertex v = node.first;
        while (v != null) {
            if(v.inTree){
                System.out.println("Vertex " + v.data + " in Tree");
            }
            e = v.firstEdge;
            while(e != null) {
                if(e.inTree){
                    System.out.println("Edge "+e.destination.data+" of weight "+ e.weight + " in Tree");
                }
                e = e.nextEdge;
            }
            v = v.next;
        }

    }
    public void print(graphHead head){
        graphVertex vertex = head.first;
        boolean[] visited = new boolean[head.count+1];
        Queue<graphVertex> queue = new LinkedList<graphVertex>();
        queue.add(vertex);
        while(!queue.isEmpty()){
            vertex = queue.poll();
            if(visited[vertex.data]) continue;
            graphEdge edges = vertex.firstEdge;
            System.out.println("Node " + vertex.data+"\nEdges:");
            while(edges != null){
                System.out.println("Edge: "+edges.destination.data+" weight: "+edges.weight);
                queue.add(edges.destination);
                edges = edges.nextEdge;
                
            }
            visited[vertex.data] = true;
        }
    }
}

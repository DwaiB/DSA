package LeetCode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReItinerary {
    class Graph{
        public Map<String,Vertex> HEAD;
        public Graph(){
            this.HEAD = new HashMap<>();
        }
        public void add(String src,String dst){
            if(!HEAD.containsKey(src)){
                HEAD.put(src,new Vertex(src));
            }
            HEAD.put(src,HEAD.get(src).add(dst));
        }
        public String toRemove(String src,String dst){
            Edge e = HEAD.get(src).EDGES;

            if(dst == null){
                return e == null ? "" : e.PORT;
            }else if(e.PORT.equals(dst)){
                return e.next == null ? e.PORT : e.next.PORT;
            }else{
                Edge ptr = e,prev = e;
                while(ptr.next != null && prev.PORT != dst){
                    prev = ptr;
                    ptr = ptr.next;
                }
                return ptr.PORT;
            }
        }
        public void remove(String src,String dst){
            Vertex V = HEAD.get(src);
            Edge ptr = V.EDGES,prev;
            prev = ptr;
            while(ptr.next != null && prev.PORT != dst){
                prev = ptr;
                ptr = ptr.next;
            }
            if(prev == ptr){
                V.EDGES = V.EDGES.next;
            }else{
                prev.next = ptr.next;
            }
        }
    }
    class Vertex{
        public String PORT;
        public Edge EDGES;
        public Vertex(String PORT){
            this.PORT = PORT;
            this.EDGES = null;
        }
        public Vertex add(String dst){
            Edge ptr = this.EDGES;
            if(ptr == null){
                this.EDGES = new Edge(dst);
            }else if(ptr.PORT.compareTo(dst) > 0){
                this.EDGES = new Edge(dst,this.EDGES);
            }else{
                Edge prev = ptr;
                while(ptr != null && ptr.PORT.compareTo(dst) < 0){
                    prev = ptr;
                    ptr = ptr.next;
                }
                Edge n = new Edge(dst);
                n.next = ptr;
                prev.next = n;
            }
            return this;
        }
        
    }
    class Edge{
        public String PORT;
        public Edge next;
        public Edge(String PORT, Edge next){
            this.PORT = PORT;
            this.next = next;
        }
        public Edge(String PORT){
            this.PORT = PORT;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        ReItinerary itr = new ReItinerary();
        Graph graph = itr.new Graph();
        
        graph.add("JFK","JEK");
        graph.add("JFK","BFC");
        graph.add("JFK","CJD");
        graph.add("JEK","JFK");
        graph.add("BFC","JFK");
        System.out.println(graph.toRemove("JFK", "CJD"));
        String org = "JFK";
        int i=5;
        List<String> list = new ArrayList<>();
        String dst=null;
        list.add(org); 
        while(i>0){
            dst = graph.toRemove(org,dst);
            System.out.println("Travel From "+ org+ " To  " + dst);
            if(graph.HEAD.get(org).EDGES.next != null && (!graph.HEAD.containsKey(dst) ||  graph.HEAD.get(dst).EDGES == null)){
                System.out.println(org +" No return for "+dst);
                Edge es = graph.HEAD.get(org).EDGES;
                while(es != null) {
                    System.out.println(es.PORT);
                    es = es.next;
                }
                System.out.println(graph.toRemove(org,dst));
                dst = graph.toRemove(org,dst);
                System.out.println("Changed Destination to "+dst);
            }
            System.out.println(org+"to Reached DESTINATION: " + dst);
            list.add(dst);
            graph.remove(org, dst);
            org = dst;
            dst = null;
            i--;
        }
        System.out.println("Destiantions:");
        for(String d : list){
            System.out.println(d);
        }
    }
}

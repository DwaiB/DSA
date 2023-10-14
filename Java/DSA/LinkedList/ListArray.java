package Java.DSA.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.Arrays.asList;

public class ListArray {
    int [] start;
    String [] elements;
    List<String> ports;
    int [] next;
    int size,end;
    public ListArray(int n){
        this.end = n;
        this.start = new int[n+1];
        Arrays.fill(start,end);
        this.ports = new ArrayList<>();
        this.elements = new String[n+1];
        this.next = new int[n+1];
    }
    
    public void add(List<String> _ticket){
        String Src = _ticket.get(0);
        String Src2 = _ticket.get(1);
        for(String _t : _ticket){
            if(!ports.contains(_t)) ports.add(_t);
        }
        
        int src = ports.indexOf(Src);
        int dst = ports.indexOf(Src2);
        int ptr = start[src];

        if(ptr == 4 || elements[ptr].compareTo(_ticket.get(1)) > 0){
            start[src] = dst;
            next[dst] = ptr;
        }else{
            int prev = ptr;
            while(ptr != 4){
                
                if(elements[ptr].compareTo(_ticket.get(1)) > 0)
                    break;
                prev = ptr;
                ptr = next[ptr];
            }
            next[dst] = ptr;
            next[prev] = dst;
        }
        elements[dst] = _ticket.get(dst);

    }
    public void remove(int element){
        
    }
    public static void main(String[] args) {
        ListArray array = new ListArray(3);
        array.add(asList("JFK","JEK"));
        array.add(asList("JFK","BFG"));
        array.add(asList("JEK","JFK"));

        for(String s: array.elements){
            System.out.println(s);
        }


    }
}

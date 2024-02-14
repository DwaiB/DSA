package Java.CodeTrix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LogFunc{
    public static void main(String[] args) throws IOException{
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(Arrays.asList(4,2));
        adj.add(Arrays.asList(2,3));
        adj.add(Arrays.asList(3,2));
        adj.add(Arrays.asList(1,2));

        Collections.sort(adj,(a,b) -> Integer.compare(a.get(0),b.get(0)));
        for(List<Integer> E : adj){
            System.out.println(E.get(0)+": "+E.get(1));
        }
    }
}
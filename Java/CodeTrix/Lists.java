package Java.CodeTrix;

import java.util.ArrayList;
import java.util.List;

public class Lists {
    public static void main(String[] args) {
        int [][] n = {{1,3},{4,7},{8,10}};

        List<int[]> list = new ArrayList<int[]>();

        list.add(n[2]);
        int [][]  nn = new int[list.size()][2];
        nn = list.toArray(nn);
        for( int [] i : nn){
            System.out.println(i[0]+" "+i[1]);
        }
    }
}

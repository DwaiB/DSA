package Java.CodeTrix;

import java.util.HashMap;
import java.util.Map;

public class bubblesort {
    public static void main(String[] args) {
        int [] arr = {12,4,2,6,8,2,9};
        int temp = 0;
        for(int i=0;i<arr.length-1;i++) {
            for(int j=0;j<arr.length-1-i;j++) {
                if(arr[j]> arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+ " " );
        }
        Map<Integer, Integer> tt = new HashMap<Integer, Integer>();
        tt.put(0,1);

        System.out.println(tt.get(0));

    }
}

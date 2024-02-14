package practice.feb4;

import java.util.Scanner;

public class SortKSortedLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("\nInput the array size: ");
            int size = sc.nextInt();
            if(size == -1){
                break;
            }
            int[] arr = new int[size];
            for(int i = 0; i< size;++i){
                arr[i] = sc.nextInt();
            }
            System.out.println("\nSorted Array: ");
            for(int i = 0; i< size;++i){
                System.out.print(arr[i]+" ");
            }
        }
        sc.close();
    }

}

package practice.dsa.feb3;

public class MergeSort {
    public static void main(String[] args) {
        int [] arr = {5,4,2,8,1,6,0,7,6};
        mergeSort(arr);
        print(arr, 0, arr.length-1);
    }
    static void print(int[] arr,int l,int r){
        System.out.println("Array: "+l+" -> "+r);
        for(int i=l;i<=r;++i){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\nFinish");
    }
    public static void mergeSort(int[] arr){
        split(arr,0,arr.length-1);
    }
    static void split(int[] arr,int l,int r){
        if(l<r){
            int m = l + (r-l)/2;
            split(arr,l,m);
            split(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }
    static void merge(int arr[], int l, int m, int r)
    {
         // Your code here
        int i = l,j = m+1,ptr = 0;
        int [] res = new int[r-l+1];
        while(i <= m && j <= r){
            if(arr[i] >= arr[j]){
                res[ptr] = arr[j];
                ++j;
                ++ptr;
            }else{
                res[ptr] = arr[i];
                ++i;
                ++ptr;
            }
        }
        while(i<=m){
            res[ptr] = arr[i];
            ++ptr;
            ++i;
        }
        while(j<=r){
            res[ptr] = arr[j];
            ++ptr;
            ++j;
        }
        for(int k=l;k<=r;++k){
            arr[k] = res[k-l];
        }
    }
}

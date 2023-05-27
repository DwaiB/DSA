package Java.CodeTrix;
public class selectionsort {
    public static void main(String[] args) {
        int [] arr = {4,6,2,4,7,9,1,8};

        for(int i = 0; i < arr.length; i++) {
            int small = i;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[small]){
                    small = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[small];
            arr[small] = temp;
        }
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+ " " );
        }
    }
}

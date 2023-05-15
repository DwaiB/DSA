public class insersionsort {
    public static void main(String[] args) {
        int  [] arr = {4,5,6,7,3,2,9};
        int i = 1,size = arr.length-1;
        while(i<size){
            int index = i;
            while( index > 0 && arr[index-1]> arr[index]){
                int temp = arr[index-1];
                arr[index-1] = arr[index];
                arr[index] = temp;
                index --;
            }
            i++;
        }
        for(i=0;i<arr.length;i++) {
            System.out.print(arr[i]+ " " );
        }
    }
}

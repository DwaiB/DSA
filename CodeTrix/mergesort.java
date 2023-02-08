public class mergesort {
    public static void merge(int[] arr,int l,int r) {
        if(l<r){
            int mid = l+(r-l)/2;
            System.out.println(l+" "+mid + " "+r);
            merge(arr, l, mid);
            merge(arr,mid+1,r);
            mergesorted(arr, l,mid,r);
        }
    }
    public static void mergesorted(int[] arr,int l,int mid,int r) {
        int [] left = new int[mid-l+1];
        int [] right = new int[r-mid];
        for(int i=0;i<mid-l+1;i++){
            left[i] = arr[l+i];
        }
        for(int i=0;i<r-mid;i++){
            right[i] = arr[mid+1+i];
        }
        int i = 0,j = 0,k=l;
        while(i< left.length && j<right.length){
            if(left[i]<=right[j]){
                arr[k] = left[i];
                i++;
            }
            else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while(i<left.length){
            arr[k++] = left[i];
            i++;
        }
        while(j<right.length){
            arr[k++] = right[j];
            j++;
        }
    }

    public static void main(String[] args) {
        int [] arr = {5,3,7,9,2,4,7,1};

        merge(arr,0,arr.length-1);

        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+ " " );
        }
    }
}

package LeetCode.quickselect;

public class kthLargestElem {

    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums,nums.length-k,0,nums.length-1);
    }
    public int quickselect(int[] nums, int k, int left,int right){
        if(left == right) return nums[k];
        
        int pos = partition(nums,left,right);
        if(pos == k){
            return nums[pos];
        }
        else if(pos>k){
            return quickselect(nums,k,left,pos-1);
        }
        else{ 
            return quickselect(nums,k,pos+1,right); 
        }
    }
    public int partition(int[] nums, int left, int pivot) {
        int j = left, i=left-1,temp;
        while(j<pivot){
            if(nums[j]< nums[pivot]){
                i++;
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            j++;
        }
        temp = nums[pivot];
        nums[pivot] = nums[i+1];
        nums[i+1] = temp;
        return i+1;
    }
    public static void main(String[] args) {
        kthLargestElem kElem = new kthLargestElem();
        int [] nums = {3,2,1,6,5,4};
        int res = kElem.findKthLargest(nums, 1);
        System.out.println("Result"+res);
    }
}

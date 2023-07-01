package Recursion.Leetcode;


import java.util.ArrayList;
import java.util.List;

public class Permutation{
    
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        
        
        
        permutation(nums,0,nums.length-1);
        
        return res;
        
    }
    public void permutation(int[] nums,int l, int r){
        List<Integer> numsList = new ArrayList<Integer>();
        for( int i : nums){
            numsList.add(i);
        }
        if(l==r){
            res.add(numsList);
        }
        else{
            for(int i=l;i<=r;i++){
                nums = swap(nums,l,i);
                permutation(nums,l+1,r);
                nums = swap(nums,l,i);
            }
        }
    }
    public int[] swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }

    public static void main(String[] args) {
        Permutation ps = new Permutation();
        int [] nums = {1,2,3};

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        result = ps.permute(nums);
        System.out.println();
        ps.display(result);
        
    }
    public void display(List<List<Integer>> result) {
        for(List<Integer> list : result) {
            System.out.print("<");
            for(Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.print(">");
        }
        System.out.println();
    }
    public void displayList(List<Integer> result) {
        System.out.print("<");
        for(Integer i : result) {
            System.out.print(i+" ");
        }
        System.out.print(">");
        System.out.println();
    }
}
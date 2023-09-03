package Java.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Permute {
    List<List<Integer>> res;

    public void print(List<Integer> queue) {
        System.out.println("Display:");
        for (int i = 0; i < queue.size(); i++) {
            System.out.print(queue.get(i) + ", ");
        }
        System.out.println();
    }

    public void print(int[] queue,int j) {
        System.out.println("List:");
        for (int i = 0; i < queue.length; i++) {
            System.out.print(queue[i] + ", ");
            if(i == j) System.out.print("|");
        }
        System.out.println();
    }

    public void print(boolean[][] queue) {
        System.out.println("List:");
        for (int i = 0; i < queue.length; i++) {
            System.out.println();
            for (int j = 0; j < queue.length; j++) {
                System.out.print(queue[i][j] + ", ");
            }
        }
        System.out.println();
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        boolean[][] dp = new boolean[n][n];
        for (boolean[] row : dp) {
            Arrays.fill(row, false);
        }
        res = new ArrayList<List<Integer>>();
        permute(nums, 0, nums.length - 1, dp);
        return res;
    }

    public void permute(int[] nums, int l, int r, boolean[][] dp) {
        List<Integer> curr = new ArrayList<Integer>();

        for (int i : nums) {
            curr.add(i);
        }
        if (l == r) {
            System.out.println("L== R");
            dp[l][r] = true;
            print(curr);
            print(dp);
            res.add(new ArrayList<>(curr));
        } else {
            for (int i = l; i <= r; i++) {
                System.out.println("L=>"+l+" I=>"+i+" R=>"+r);
                if(!dp[l][i]) {
                nums = swap(nums, l, i);
                
                print(nums,i);
                dp[l][i] = true;
                permute(nums, l + 1, r, dp);
                nums = swap(nums, l, i);
                }
                
            }
        }
    }

    public int[] swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }

    public static void main(String[] args) {
        Permute per = new Permute();
        int[] nums = { 1, 1, 2 };
        per.permuteUnique(nums);
    }
}
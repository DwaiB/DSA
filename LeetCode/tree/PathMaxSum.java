import generic.TreeNode;

public class PathMaxSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int sum = findSum(root,0);
        return Math.max(sum,maxSum);
    }
    public int findSum(TreeNode root, int sum){
        if(root == null) return sum;

        int left = findSum(root.left,0);
        int right = findSum(root.right,0);
        sum = Math.max(left+sum+root.val,right+sum+root.val);
        sum = Math.max(sum,root.val);
        // System.out.println("Sum:"+sum);
        maxSum = Math.max(maxSum,left+right+root.val);
        maxSum = Math.max(maxSum,sum);
        
        // System.out.println("Root:"+root.val+"\tMax:"+maxSum);
        return sum;
    }
}
/*
 * Solution with 0ms 
 * Same logic with redundant steps deleted
 */
class Solution {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        helpMethod(root);
        return max;
    }

    public int helpMethod(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftSum = Math.max(helpMethod(root.left),0);
        int rightSum = Math.max(helpMethod(root.right),0);

        max = Math.max(max,leftSum+rightSum+root.val);

        return Math.max(root.val+leftSum, root.val+rightSum);
    }
}
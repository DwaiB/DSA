import generic.TreeNode;

public class BalancedTree {
    boolean res=true;
    public boolean isBalanced(TreeNode root) {
        int a = depthMax(root);
        return res;
    }
    public int depthMax(TreeNode root){
        if(root == null || res == false) return 0;
        int count = 1;
        int left = depthMax(root.left);
        int right = depthMax(root.right);
        if (Math.abs(left-right) >1 ) res = false;
        return left>right ? left+count:right+count;
    }
}

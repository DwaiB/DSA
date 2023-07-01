import generic.TreeNode;

public class DiameterOfTree{
    int max =0;
    public int diameterOfBinaryTree(TreeNode root) {
        max = Math.max(depthMax(root)-1,max);
        return max;
    }
    public int depthMax(TreeNode root){
        if(root == null) return 0;
        int count = 1;
        int left = depthMax(root.left);
        int right = depthMax(root.right);
        max  = Math.max(left+right,max);
        return left>right ? left+count:right+count;
    }
}
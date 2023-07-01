import generic.TreeNode;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        return 1+ Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}

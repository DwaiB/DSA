package Java.DSA.Tree.BinaryTree;
public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
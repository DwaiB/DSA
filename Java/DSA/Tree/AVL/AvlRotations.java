package Java.DSA.Tree.AVL;

import Java.DSA.Tree.BinaryTree.TreeNode;

public class AvlRotations {
    public TreeNode LLRoation(TreeNode root){
        if(root == null || root.left == null){
            return root;
        }
        TreeNode leftNode = root.left;
        TreeNode leftRNode = leftNode.right;
        leftNode.right = root;
        root.left = leftRNode;
        root = leftNode;
        return root;
    }
    public TreeNode RRRotation(TreeNode root){
        if(root == null || root.right == null){
            return root;
        }
        TreeNode rightNode = root.right;
        TreeNode rightLNode = rightNode.left;
        rightNode.left = root;
        root.right = rightLNode;
        root = rightNode;
        return root;
    }
    public TreeNode LRRotation(TreeNode root){
        if(root == null || root.left == null || root.left.right == null){
            return root;
        }
        TreeNode leftNode = root.left;
        TreeNode leftRNode = leftNode.right;
        root.left = leftRNode.right;
        leftNode.right = leftRNode.left;
        leftRNode.left = leftNode;
        leftRNode.right = root;
        root = leftRNode;
        return root;
    }
    public TreeNode RLRotation(TreeNode root){
        if(root == null || root.right == null || root.right.left == null){
            return root;
        }
        TreeNode rightNode = root.right;
        TreeNode rightLNode = rightNode.left;
        root.right = rightLNode.left;
        rightNode.left = rightLNode.right;
        rightLNode.left = root;
        rightLNode.right = rightNode;
        root = rightLNode;
        return root;
    }
}

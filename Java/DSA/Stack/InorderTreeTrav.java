package Java.DSA.Stack;
import java.util.ArrayList;
import java.util.List;

import Java.DSA.Tree.BinaryTree.TreeNode;

public class InorderTreeTrav{
    public static  List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        inorder(root,result);
        return result;
    }
    public static void inorder(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.data);
        inorder(root.right, result);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode curr = root;
        curr.data = 1;
        curr.left = new TreeNode(2);
        curr.right = new TreeNode(3);
        TreeNode lol = curr.right;
        curr = curr.left;
        curr.left = new TreeNode(4);
        curr.right = new TreeNode(5);
        lol.left = new TreeNode(6);
        lol.right = new TreeNode(7);
        List<Integer> result = new ArrayList<Integer>();
        result = inorderTraversal(root);
        result.forEach(System.out::println);
    }
}
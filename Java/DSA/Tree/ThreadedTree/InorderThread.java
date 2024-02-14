package Java.DSA.Tree.ThreadedTree;

import Java.DSA.Tree.BST.BinarySearchTree;
import Java.DSA.Tree.BinaryTree.TreeNode;

public class InorderThread{

    public void threadIt(TreeNode root,TreeNode parent){
        if(root == null){
            return;
        }
        threadIt(root.left, root);
        threadIt(root.right, parent);
        if(root.right == null){
            root.right = parent;
        }
    }
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Integer[] nodes = {7,5,15,2,6,1,3,4};
        tree.insert(nodes);
        TreeNode root = tree.root;
        System.out.println("Using lib func Inorder");
        tree.Inorder();
        InorderThread obj = new InorderThread();
        obj.threadIt(root, null);
        TreeNode node = root;
        while(node.left != null) {
            node = node.left;
        }
        System.out.println("\nInorder starting from " + node.data);
        while(node != null) {
            System.out.print(node.data+"->");
            node = node.right;
        }
    }
}
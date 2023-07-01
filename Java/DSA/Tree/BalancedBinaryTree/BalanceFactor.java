package Java.DSA.Tree.BalancedBinaryTree;

import Java.DSA.Tree.BinaryTree.BinaryTree;
import Java.DSA.Tree.BinaryTree.TreeNode;

/*
 * For a Tree T Balance Factor BF(T) is:
 * 0 if the tree T is null
 * else
 * The absolute difference of the height between T's children. 
 * Thus BF value is it's left child leftH minus the height of it's right child rightH.
 * BF(T) = |leftH - rightH|  || ( BF(T)= |leftH - rightH| <=1 for AVL)
 */
public class BalanceFactor {
    boolean isBF=true;
    public int checkBalanceFactor(TreeNode root){
        if(root == null ) return 0;
        int left  = checkBalanceFactor(root.left);
        int right = checkBalanceFactor(root.right);
        int BF = Math.abs(left-right);
        if(BF > 1){
            isBF = false;
        }
        return Math.max(left, right)+1;
    }
    public static void main(String[] args) {
        BalanceFactor BF = new BalanceFactor();
        Integer[] array = {10,7,6,9,11,null,3,1,null};
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.createTree(array);
        System.out.println("Tree\n");
        tree.Inorder(root);
        int c = BF.checkBalanceFactor(root);
        System.out.println("\nHeight:"+c+ "\nBalanced:"+BF.isBF);
    }
}
class NotBalancedException extends RuntimeException{
    
    NotBalancedException(String message){
        super(message);
        System.out.println("NotBalancedException Called");
    }
}

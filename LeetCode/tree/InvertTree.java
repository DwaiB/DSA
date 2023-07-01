import java.util.LinkedList;
import java.util.Queue;

import generic.BinaryTree;
import generic.TreeNode;


class InvertTree {
    
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> qtree = new LinkedList<TreeNode>();
        qtree.add(root);
        while(!qtree.isEmpty()){
            TreeNode node,left=null,right=null;
            node = qtree.remove();
            if(node.left!=null){
                left = node.left;
            }
            if(node.right!=null){
                right = node.right;
            }
            if(left!=null && right!=null){
                node.right = left;
                node.left = right;
            }else if(left == null){
                node.left = right;
                node.right=null;
            }else{
                node.right = left;
                node.left = null;
            }
            if(right!=null) qtree.add(right);
            if(left!=null) qtree.add(left);
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = {4,2,7,1,3,6,9};
        TreeNode tree = BinaryTree.createTree(arr);
        InvertTree itree = new InvertTree();
        TreeNode res = itree.invertTree(tree);
        BinaryTree.Inorder(res);
    }
}
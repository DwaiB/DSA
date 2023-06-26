package Java.DSA.Tree.BalancedBinaryTree;

import Java.DSA.Tree.BinaryTree.TreeNode;

public class BalanceTree {
    TreeNode root;

    public BalanceTree() {
        root = null;
    }

    public TreeNode find(int data) {
        if (root == null)
            return null;
        if (root.data == data) {
            return root;
        }
        TreeNode save = root, ptr;
        if (data <= root.data) {
            ptr = root.left;
        } else {
            ptr = root.right;
        }
        while (ptr != null) {
            if (ptr.data == data) {
                return save;
            }
            save = ptr;
            if (data <= ptr.data) {
                ptr = ptr.left;
            } else {
                ptr = ptr.right;
            }
        }
        return save;
    }

    public void insert(int data){
        TreeNode node =  new TreeNode(data);
        if(root == null){
            root = node;
            return;
        }
        TreeNode par = find(data);
        TreeNode ptr,save = root;
        if(par.data <= data){
            if(data < par.data){
                ptr = par.left;
                par.left = node;
                node.left = ptr;
            }
        }
    }
}

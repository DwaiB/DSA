package Java.DSA.Tree.AVL;


import Java.DSA.Tree.BinaryTree.TreeNode;
import Java.DSA.Tree.BinaryTree.Traverse;

public class AvlTree {
    TreeNode root;

    public TreeNode find(int item) {
        if (root == null) {
            return null;
        }
        if(root.data == item){
            return root;
        }
        TreeNode save = root, ptr;
        if (root.data  < item){
            ptr = root.right;
        }else {
            ptr = root.left;
        }
        while (ptr != null) {
            if (ptr.data == item) {
                return save;
            }
            save = ptr;
            if (item > ptr.data) {
                ptr = ptr.right;
            } else {
                ptr = ptr.left;
            }
        }
        return save;
    }

    public void insert(int item) {
        TreeNode temp = find(item), node;
        if (temp != null && ((temp.left != null && temp.left.data == item) ||
                (temp.right != null && temp.right.data == item) || temp.data == item)) {
            return;
        }
        node = new TreeNode(item);
        if(temp == null){
            root = node;
        }
        else if (temp.data < item) {
            temp.right = node;
        } else {
            temp.left = node;
        }
    }

    public void deleleCaseA(TreeNode par,TreeNode loc){
        TreeNode child;
        if(loc.left == null && loc.right == null){
            child = null;
        }
        else if (loc.left !=null){
            child = loc.left;
        }else{
            child = loc.right;
        }
        if(par!=null){
            if(loc == par.left){
                par.left = child;
            }else{
                par.right = child;
            }
        }else{
            root = child;
        }
    }
    public void deleteCaseB(TreeNode par,TreeNode loc){
        TreeNode suc,parsuc,save,ptr;
        save = loc;
        ptr = loc.right;
        while(ptr.left!=null){
            save = ptr;
            ptr = ptr.left;
        }
        suc = ptr;
        parsuc = save;
        deleleCaseA(parsuc, suc);
        if(par!=null){
            if(par.left == loc){
                par.left = suc;
            }else{
                par.right = suc;
            }
        }else{
            root = suc;
        }
        suc.left = loc.left;
        suc.right = loc.right;
    }
    public void delete(int item){
        TreeNode par = find(item),loc=null;
        if(par!=null && par.data == item){
                loc = par;
                par = null;
            }
        if(par!=null){
            if(par.left!=null && par.left.data == item){
                loc = par.left;
            }else if( par.right != null && par.right.data == item){
                loc = par.right;
            }
        }
        if(loc == null){
            return;
        }else if (loc.left!=null && loc.right != null){
            deleteCaseB(par, loc);
        }else{
            deleleCaseA(par, loc);
        }
    }

    public static void main(String[] args) {
        AvlTree tree = new AvlTree();
        tree.insert(4);
        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        tree.insert(8);
        tree.insert(10);
        tree.insert(6);
        tree.insert(7);
        tree.insert(5);
        tree.insert(9);
        tree.insert(11);
        System.out.println("Preorder");
        Traverse.PreOrder(tree.root);
        System.out.println("\nInorder");
        Traverse.Inorder(tree.root);
        tree.delete(6);
        System.out.println("After delete 6 \n");
         System.out.println("Preorder");
        Traverse.PreOrder(tree.root);
        System.out.println("\nInorder");
        Traverse.Inorder(tree.root);
    }
}

package Java.DSA.Tree.BST;

import Java.DSA.Tree.BinaryTree.TreeNode;

public class BSTDelete {
    TreeNode root;
    BSTDelete(TreeNode root){
        this.root = root;
    }
    public void caseA(TreeNode par,TreeNode loc){
        TreeNode child;
        if(loc.left == null && loc.right == null){
            child = null;
        }
        else if (loc.left != null){
            child  = loc.left;
        }
        else{
            child = loc.right;
        }

        if(par!=null){
            if(par.left == loc){
                par.left=child;
            }else{
                par.right = child;
            }
        }else{
            root = child;
        }
    }
    public void caseB(TreeNode par,TreeNode loc){
        TreeNode suc,parsuc,save,ptr;
        save = loc;
        ptr = loc.right;
        while(ptr.left!=null){
            save = ptr;
            ptr = ptr.left;
        }
        suc = ptr;
        parsuc = save;
        caseA(parsuc, suc);
        if(par!=null){
            if(loc == par.left){
                par.left = suc;
            }
            else{
                par.right = suc;
            }
        }else{
            root = suc;
        }
        suc.left = loc.left;
        suc.right = loc.right;
    }
    public void delete(int item,BinarySearchTree tree){
        TreeNode loc=null;
        TreeNode par = tree.find(item, root);
        if(par != null && par.data == item){
            loc = par;
            par = null;
        }
        else if (par.left != null && par.left.data == item){
            loc = par.left;
        }
        else if(par.right != null && par.right.data == item) {
            loc = par.right;
        }
        if(loc == null){
            return;
        }
        if(loc.right!=null && loc.left!=null){
            caseB(par, loc);
        }else{
            caseA(par, loc);
        }
    }
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Integer arr [] = {4,2,8,1,3,6,10,null,null,null,null,5,7,9,null};
        tree.insert(arr);
        tree.Inorder(tree.root);
        System.out.println();
        BSTDelete BSTD = new BSTDelete(tree.root);
        BSTD.delete(6, tree);
        tree.Inorder(BSTD.root);
    }
}

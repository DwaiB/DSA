import generic.BinaryTree;
import generic.TreeNode;

public class InsertIntoBST {
    public TreeNode find(TreeNode root, int val){
        if(root == null || root.val == val) { return root;}
        TreeNode ptr,save = root;
        if(root.val > val){
            ptr = root.left;
        }else{
            ptr = root.right;
        }
        while(ptr != null){
            save = ptr;
            if(ptr.val > val){
                ptr = ptr.left;
            }else{
                ptr = ptr.right;
            }
        }
        return save;
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode New = new TreeNode(val);
        TreeNode par = find(root, val);
        System.out.println(par.val);
        if(par.val <= val){
            New.right = par.right;
            par.right = New;
        }else{
            New.left = par.left;
            par.left = New;
        }
        return root; 
    }
    public static void main(String[] args) {
        InsertIntoBST IST = new InsertIntoBST();
        // Integer[] t = {8,1,9,null,6,null,null,3,7,2,5,null,null};
        Integer[] t = {4,3,7,2,null,6,null};
        TreeNode root = BinaryTree.createTree(t);
        TreeNode pNode = IST.find(root, 5);
        System.out.println(pNode.val);

    }
}

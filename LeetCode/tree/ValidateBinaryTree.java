import generic.TreeNode;

public class ValidateBinaryTree {
    boolean ans = true,first = false;
    int seq;
    // Stack<Integer> stack = new Stack<Integer>();
    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right==null)) return true;
        if(isValidBST(root.left)){
            seq = root.val;
        }
        else if(root.val <= seq){
            return false;
        }
        else{
            return isValidBST(root.right);
        }
        return true;
    }
    // public boolean isValidBST(TreeNode root) {
    //     if(root == null || (root.left == null && root.right==null)) return ans;
    //     travInorder(root);
    //     return ans;
    // }
    public void travInorder(TreeNode root){
        if(root == null || ans == false) 
            return;
        travInorder(root.left);
        if(first == true &&  root.val <= seq){
            System.out.println("Root: "+root.val);
            ans = false;
            return;
        }
        if(first == false)
            first = true;
        seq = root.val;
        travInorder(root.right);
    }
}

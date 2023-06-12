import generic.TreeNode;

public class IsSubtree {
    boolean ans = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        checkIsSubtree(root,subRoot);
        return ans;
    }
    public void checkIsSubtree(TreeNode root, TreeNode subRoot) {
        if(ans == true || root == null) return;
        if(root!=null){
            if(root.val == subRoot.val && isSameTree(root,subRoot)) ans = true;
            if(ans == false){
                checkIsSubtree(root.left,subRoot);
                checkIsSubtree(root.right,subRoot);
            }
        }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q ==null) return true;
        if(p!=null && q!=null){
            if(p.val == q.val){
                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
            }else{
                return false;
            }
        }
        return false;
    }
}

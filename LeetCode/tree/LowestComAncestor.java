import generic.TreeNode;

public class LowestComAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        if(root.left!=null && root.right!=null){
            if((root.val >= p.val && root.val <= q.val) ||(root.val <= p.val && root.val >= q.val)){
                return root;
            }
            else if ( root.val < p.val && root.val < q.val){
                return lowestCommonAncestor(root.right,p,q);
            }
            else if ( root.val > p.val && root.val > q.val){
                return lowestCommonAncestor(root.left,p,q);
            }
        }
        return root;
    }
}

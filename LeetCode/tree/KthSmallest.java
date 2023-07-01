import generic.TreeNode;

public class KthSmallest{
    int ans,seq =0;
    public int kthSmallest(TreeNode root, int k) {
        kthInorder(root,k);
        return ans;
    }
    public void kthInorder(TreeNode root, int k){
        if(root == null || seq == k) return;
        kthInorder(root.left,k);
        seq++;
        if(seq == k){
            ans = root.val;
            return;
        }
        kthInorder(root.right,k);
    }
}
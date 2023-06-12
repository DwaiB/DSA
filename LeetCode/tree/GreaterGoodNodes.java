import generic.TreeNode;

public class GreaterGoodNodes {
    int good = 0;
    public int goodNodes(TreeNode root) {
        if(root == null){
            return good;
        }
        isGood(root,root.val);
        return good;
    }
    public void isGood(TreeNode root,int max){
        if(root == null) return;
        if(root.val >=max){
            good++;
            max = root.val;
        }
        isGood(root.left,max);
        isGood(root.right,max);
    }
}

import java.util.ArrayList;
import java.util.List;

import generic.TreeNode;

public class BinaryTreeRightView {
    int maxDepth=0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        viewFromRight(root,0,list);
        return list;
    }
    public void viewFromRight(TreeNode root,int depth,List<Integer> list){
        if(root == null) return;

        if(depth+1 > maxDepth){
            maxDepth = depth + 1;
            list.add(root.val);
        }
        viewFromRight(root.right,depth+1,list);
        viewFromRight(root.left,depth+1,list);
    }
}

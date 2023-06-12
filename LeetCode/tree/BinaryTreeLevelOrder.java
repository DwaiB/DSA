import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import generic.TreeNode;

public class BinaryTreeLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) 
            return res;
        
        List<Integer> temp= new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<TreeNode> save = new ArrayList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
           temp = new ArrayList<Integer>(); 
            save = new ArrayList<TreeNode>();
            while(!queue.isEmpty()){
                TreeNode node = queue.remove();
                save.add(node);
                temp.add(node.val);
            }
            res.add(temp);
            for(TreeNode itr : save){
                if(itr.left!=null)
                    queue.add(itr.left);
                if(itr.right!=null)
                    queue.add(itr.right);
            }
        }
        return res;
    }
}

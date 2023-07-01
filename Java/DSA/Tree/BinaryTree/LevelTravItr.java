package Java.DSA.Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelTravItr {
    TreeNode root;

    public boolean isComplete(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();

            if(temp.left!=null){
                if(flag== true){
                    return false;
                }
                queue.add(temp.left);
            }
            else{
                flag = true;
            }
            if(temp.right!=null){
                if(flag== true){
                    return false;
                }
                queue.add(temp.right);
            }
            else{
                flag = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LevelTravItr tree = new LevelTravItr();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.right = new TreeNode(5);
        tree.root.left.left = new TreeNode(4);
        tree.root.right.right = new TreeNode(6);
          
      
        if (tree.isComplete(tree.root))
            System.out.print("The binary tree is complete");
        else
            System.out.print("The binary tree is not complete");
    }
}

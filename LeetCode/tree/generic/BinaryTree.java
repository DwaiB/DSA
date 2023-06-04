package generic;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public BinaryTree(){}

    public static TreeNode createTree(Integer[] arr){
        int k = 1,n=arr.length;
        TreeNode root = new TreeNode(arr[0]);
        TreeNode curr = root,temp;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(curr);
        while(2*k < n){
            temp = queue.remove();
            if(arr[2*k-1] != null)
                temp.left = new TreeNode(arr[2*k-1]);
            if(arr[2*k]!=null)
                temp.right = new TreeNode(arr[2*k]);
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
            k++;
        }
        queue.clear();
        return root;
    }
    public static void Inorder(TreeNode node){
        if(node == null) return;
        Inorder(node.left);
        System.out.print(node.val+" ");
        Inorder(node.right);
    }

}

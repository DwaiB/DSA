import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import generic.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> data = new ArrayList<Integer>();
        TreeNode node;
        queue.add(root);
        while(!queue.isEmpty()){
            node = queue.remove();
            if(node!=null){
                data.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            else{
                data.add(null);
            }
        }
        return Arrays.toString(data.toArray());
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int k=0;
        data = data.substring(0+1, data.length()-1);
        String[] values = data.split(","); 
        Integer [] intVal = new Integer[values.length];
        for(String val : values){
            intVal[k++] = Integer.parseInt(val);
        }
        return createTree(intVal);
    }
    public TreeNode createTree(Integer[] arr){
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


    public static void main(String[] args) {
        Codec ser = new Codec();
        Codec deser = new Codec();
        System.out.println(ser.serialize(new TreeNode(1)));
        deser.deserialize(ser.serialize(new TreeNode(1)));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
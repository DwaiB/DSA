package Java.DSA.Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;
    BinaryTree(){}

    public void createTree(Integer[] arr){
        int k = 1,n=arr.length;
        if(root == null){
            root = new Node(arr[0]);
        }
        Node curr = root,temp;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(curr);
        while(2*k < n){
            temp = queue.remove();
            if(arr[2*k-1] != null)
                temp.left = new Node(arr[2*k-1]);
            if(arr[2*k]!=null)
                temp.right = new Node(arr[2*k]);
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
            k++;
        }
        queue.clear();
    }
    public void Inorder(Node node){
        if(node == null) return;
        Inorder(node.left);
        System.out.print(node.data+" ");
        Inorder(node.right);
    }

    public static void main(String[] args) {
        Integer [] arr = {1,2,3,4,null,5,6,7,8,9,10,null,11};
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createTree(arr);
        int n = arr.length,level;
        level = (int) Math.floor(Math.log(n)+1)-1;
        System.out.println("Levels:"+level+"\n");
        binaryTree.Inorder(binaryTree.root);
        System.out.println();
    }
}

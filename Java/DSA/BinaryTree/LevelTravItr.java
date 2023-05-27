package Java.DSA.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelTravItr {
    Node root;

    public boolean isComplete(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            Node temp = queue.remove();

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
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.left.left = new Node(4);
        tree.root.right.right = new Node(6);
          
      
        if (tree.isComplete(tree.root))
            System.out.print("The binary tree is complete");
        else
            System.out.print("The binary tree is not complete");
    }
}

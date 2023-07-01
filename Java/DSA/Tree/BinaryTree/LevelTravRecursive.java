package Java.DSA.Tree.BinaryTree;

public class LevelTravRecursive {
    TreeNode root;

    public int countNodes(TreeNode node) {
        if(node == null) return 0;

        return (1+ countNodes(node.left) + countNodes(node.right));
    }

    public boolean isComplete(TreeNode root, int index, int count){
        if(root == null) return true;

        if(index >= count) return false;

        return (isComplete(root.left, index*2 +1 , count)
                && isComplete(root.right, index*2 +2 , count));
    }

    public static void main(String args[])
    {
        LevelTravRecursive tree = new LevelTravRecursive();
         
        // Le us create tree in the last diagram above
        
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.right = new TreeNode(5);
        tree.root.left.left = new TreeNode(4);
        tree.root.right.right = new TreeNode(6);
          
        int node_count = tree.countNodes(tree.root);
        int index = 0;
          
        if (tree.isComplete(tree.root, index, node_count))
            System.out.print("The binary tree is complete");
        else
            System.out.print("The binary tree is not complete");
    }
}

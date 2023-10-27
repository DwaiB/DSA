import generic.BinaryTree;
import generic.TreeNode;

public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        TreeNode parent = null;
        TreeNode node = root;
        boolean left = false;
        while (node.val != key) {
            parent = node;
            if (node.val < key) {
                left = false;
                node = node.right;
            } else {
                left = true;
                node = node.left;
            }
            if(node == null) return root;
        }

        if(node.right != null){
            TreeNode rightChild = node.right;
            if(rightChild.left == null){
                rightChild.left = node.left;
                root = assignParent(parent,rightChild,left,root);

            }else{
                TreeNode prev = rightChild,itr = rightChild.left;
                while(itr.left!= null){
                    prev = itr;
                    itr = itr.left;
                }
                prev.left = itr.right;
                itr.right = rightChild;
                itr.left = node.left;
                root = assignParent(parent,itr,left,root);
            }
        }else{
            root = assignParent(parent,node.left,left,root);
        }
        return root;
    }
    public TreeNode assignParent(TreeNode parent, TreeNode node, boolean left,TreeNode root) {
        if(parent == null){
            return node;
        }
        if (left) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return root;
    }
    public static void main(String[] args) {
        Integer[] arr = { 8, 4, 11, 2, 7, 9, 13, 1, 3, 5, null, null, 10, 12, 14, null, null, null, null, null, 6 };
        TreeNode root = BinaryTree.createTree(arr);
        DeleteNodeInBST deleteNode = new DeleteNodeInBST();
        
        root = deleteNode.deleteNode(root, 4);
        BinaryTree.Inorder(root);
    }
}

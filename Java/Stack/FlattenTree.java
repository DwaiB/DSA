public class FlattenTree {
    public static void flatten(TreeNode root) {
        if(root == null) return;
        if(root.left!=null && root.right != null){
            TreeNode rightChild = root.right;
            root.right = root.left;
            if(root.left.right!=null){
                TreeNode leftRNode = root.left.right;
                
            }
            else {
                root.right.right = rightChild;
            }
            
        }
        flatten(root.left);
        flatten(root.right);
    }
    public static void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode curr = root;
        curr.val = 1;
        curr.left = new TreeNode(2);
        curr.right = new TreeNode(3);
        flatten(root);
        inorder(root);
        // TreeNode lol = curr.right;
        // curr = curr.left;
        // curr.left = new TreeNode(4);
        // curr.right = new TreeNode(5);
        // lol.left = new TreeNode(6);
        // lol.right = new TreeNode(7);
    }
}

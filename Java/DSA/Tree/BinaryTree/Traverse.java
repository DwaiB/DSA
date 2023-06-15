package Java.DSA.Tree.BinaryTree;

public class Traverse {
    public static void Inorder(TreeNode node){
        if(node == null) return;
        Inorder(node.left);
        System.out.print("->"+node.data);
        Inorder(node.right);
    }
    public static void PreOrder(TreeNode node){
        if(node == null) return;
        System.out.print("-> "+node.data);
        PreOrder(node.left);
        PreOrder(node.right);
    }
    public static void PostOrder(TreeNode node){
        if(node == null) return;
        PostOrder(node.left);
        PostOrder(node.right);
        System.out.print("->"+node.data);
    }
}

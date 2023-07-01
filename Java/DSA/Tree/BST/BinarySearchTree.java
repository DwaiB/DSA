package Java.DSA.Tree.BST;

import Java.DSA.Tree.BinaryTree.TreeNode;

public class BinarySearchTree {
    TreeNode root;
    BinarySearchTree(){}
    
    public TreeNode find(Integer data,TreeNode root){
        if(root == null) return null;
        if(root.data == data) return root;

        TreeNode ptr,save;
        save = root;
        if(root.data > data)
            ptr = root.left;
        else
            ptr = root.right;
        while(ptr!=null){
            if(data == ptr.data)
                return save;
            save = ptr;
            if(data < ptr.data)
                ptr = ptr.left;
            else
                ptr = ptr.right;
            
        }
        return save;
    }
    public void insert(Integer[] arr){
        TreeNode temp,item;
        for(int i=0;i<arr.length;i++){
            temp = find(arr[i],root);
            if(temp != null && 
            ((temp.left!=null && temp.left.data == arr[i]) ||
             (temp.right!=null && temp.right.data == arr[i]))){
                continue;
            }
            item = new TreeNode(arr[i]);
            if(temp == null){
                root = new TreeNode(arr[i]);
            }
            else if (arr[i] < temp.data){
                temp.left = item;
            }else{
                temp.right = item;
            }
        }
    }
    public void Inorder(TreeNode node){
        if(node == null) return;
        Inorder(node.left);
        System.out.print(node.data+" ");
        Inorder(node.right);
    }
    public void PreOrder(TreeNode node){
        if(node == null) return;
        
        System.out.print(node.data+" ");
        PreOrder(node.left);
        PreOrder(node.right);
    }
    public static void main(String[] args) {
        BinarySearchTree BST = new BinarySearchTree();
        Integer  [] arr = {2,4,7,5,1,8,9,6,3};
        BST.insert(arr);
        System.out.println("In Order: \n");
        BST.Inorder(BST.root);
        System.out.println();
        System.out.println("Pre Order: \n");
        BST.PreOrder(BST.root);
        System.out.println();
    }
}

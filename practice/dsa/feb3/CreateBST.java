package practice.dsa.feb3;

import Java.DSA.Tree.BinaryTree.TreeNode;

public class CreateBST {
    static TreeNode head;
    public static void createBST(int[] arr){
        for(int i=0;i<arr.length;++i){
            TreeNode par = find(arr[i]);
            if(par == null){
                head = new TreeNode((arr[i]));
            }
            else if(par.data <= arr[i] && par.right == null){
                par.right = new TreeNode(arr[i]);
            }else{
                par.left = new TreeNode(arr[i]);
            }
        }
    }    
    public static TreeNode find(int x){
        if(head == null){
            return head;
        }
        TreeNode par=null,ptr = head;
        while(ptr !=null){
            par = ptr;
            if(ptr.data < x){
                ptr = ptr.right;
            }else{
                ptr = ptr.left;
            }
        }
        return par;
    }
    public static void main(String[] args) {
        int[] arr  = {6,5,3,7,1,7,9,6};
        createBST(arr);
        System.out.println("Root "+head.data);
        Inorder(head);
    }
    static void Inorder(TreeNode head){
        if(head == null) return;
        Inorder(head.left);
        System.out.println(head.data);
        Inorder(head.right);
    }
}

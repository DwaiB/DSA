package Java.DSA.Tree.BST;

public class BinarySearchTree {
    Node root;
    BinarySearchTree(){}
    
    public Node find(int data,Node root){
        if(root == null) return null;
        if(root.data == data) return root;

        Node ptr,save;
        save = root;
        if(root.data > data)
            ptr = root.left;
        else
            ptr = root.right;
        while(ptr!=null){
            if(data == ptr.data)
                return ptr;
            save = ptr;
            if(data < ptr.data)
                ptr = ptr.left;
            else
                ptr = ptr.right;
            
        }
        return save;
    }
    public void insert(int[] arr){
        Node temp,item;
        for(int i=0;i<arr.length;i++){
            temp = find(arr[i],root);
            if(temp != null && temp.data == arr[i]){
                continue;
            }
            item = new Node(arr[i]);
            if(temp == null){
                root = new Node(arr[i]);
            }
            else if (arr[i] < temp.data){
                temp.left = item;
            }else{
                temp.right = item;
            }
        }
    }
    public void Inorder(Node node){
        if(node == null) return;
        Inorder(node.left);
        System.out.print(node.data+" ");
        Inorder(node.right);
    }
    public void PreOrder(Node node){
        if(node == null) return;
        
        System.out.print(node.data+" ");
        PreOrder(node.left);
        PreOrder(node.right);
    }
    public static void main(String[] args) {
        BinarySearchTree BST = new BinarySearchTree();
        int [] arr = {2,4,7,5,1,8,9,6,3};
        BST.insert(arr);
        System.out.println("In Order: \n");
        BST.Inorder(BST.root);
        System.out.println();
        System.out.println("Pre Order: \n");
        BST.PreOrder(BST.root);
        System.out.println();
    }
}

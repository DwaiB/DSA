package Java.DSA.Tree.AVL;

import Java.DSA.Tree.BST.BinarySearchTree;

public class AVLTest {
    public static void main(String[] args) {
        AvlRotations avl = new AvlRotations();
        BinarySearchTree tree = new BinarySearchTree();
        Integer [] arr = {2,7,4,1,6,5,9,3,8};

        tree.insert(arr);
        tree.PreOrder();
        System.out.println();
        tree.root = avl.RRRotation(tree.root);
        tree.root = avl.RLRotation(tree.root);
        tree.Inorder();
        System.out.println();
        tree.PreOrder();
    }
}

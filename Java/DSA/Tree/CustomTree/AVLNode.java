package Java.DSA.Tree.CustomTree;

public class AVLNode<T> {
    public T data;
    public AVLNode<T> left,right;
    public AVLNode(){
        left = null;
        right = null;
    }
    public AVLNode(T data){
        this.data = data;
        left = null;
        right = null;
    }
}

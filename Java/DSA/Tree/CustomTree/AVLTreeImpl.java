package Java.DSA.Tree.CustomTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AVLTreeImpl<T extends Comparable<T>>{
    List<AVLNode<T>> treeList;
    public AVLTreeImpl(){
        treeList = new ArrayList<AVLNode<T>>();
    }
    public AVLNode<T> find(T item){
        if(treeList.size() == 0){ return null;}
        AVLNode<T> root = treeList.get(0),save,ptr;
        if(root.data.compareTo(item) == 0) return root;
        save = root;
        if(root.data.compareTo(item) < 0){
            ptr = root.right;
        }else{
            ptr = root.left;
        }
        while(ptr!=null){
            if(ptr.data==item){
                return save;
            }
            save = ptr;
            if(item.compareTo(ptr.data) > 0){
                ptr = ptr.right;
            }else{
                ptr = ptr.left;
            }
        }
        return save;
    }
    public void insert(T item){
        AVLNode<T> temp = find(item),node;
        if(temp!=null && (
            ( temp.left!=null  && temp.left.data.compareTo(item)  == 0) || 
            ( temp.right!=null && temp.right.data.compareTo(item) == 0) )){
                return;
        }
        node = new AVLNode<T>(item);
        treeList.add(node);
        if (temp.data.compareTo(item) < 0){
            temp.right = node;
        }else{
            temp.left = node;
        }
    } 
    /*
     * Create a Tree from array with heights
     */
    public AVLNode<T> createAvlTree(T [] array){
        if(array.length==0) return null;
        
        int size = array.length,index=1;
        int height = (int) Math.floor(Math.log(size)+1);

        AVLNode<T> root = new AVLNode<T>(array[0]);
        Queue<AVLNode<T>> queue = new LinkedList<AVLNode<T>>();
        AVLNode<T> temp;
        queue.add(root);

        while(2*index < size){
            temp = queue.remove();
            if(isNextLevel(2*index))
                height--;

            if(array[2*index-1]!=null)
                temp.left = new AVLNode<T>(array[2*index-1]);
            if(array[2*index]!=null)
                temp.right = new AVLNode<T>(array[2*index]);
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!= null)
                queue.add(temp.right);
            index++;
        }
        return root;
    }
    public boolean isNextLevel(int index){
        if(index == 2 || index == 4 || index == 8  || index == 16 || index == 32){
            return true;
        }
        return false;
    }
    public void Inorder(AVLNode<T> node){
        if(node == null) return;
        Inorder(node.left);
        System.out.println("-> Val:"+node.data);
        Inorder(node.right);
    }
    public static void main(String[] args) {
        AVLTreeImpl<Integer> tree = new AVLTreeImpl<Integer>();
        Integer [] array = {4,2,8,1,3,6,10,null,null,null,null,5,7,9,null};
        AVLNode<Integer> root = tree.createAvlTree(array);
        System.out.println("Inorder\n");
        tree.Inorder(root);
    }
}

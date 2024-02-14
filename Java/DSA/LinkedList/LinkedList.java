package Java.DSA.LinkedList;

import java.util.HashMap;
import java.util.Map;

abstract class ListNode{}

public interface LinkedList<K>{
    public void add(K item);
    public void remove(K item);
    public ListNode get(K value);
}
class Node<K> extends ListNode{
    public K value;
    public Node<K> next;
    public Node(){
        this.value = null;
        this.next  =null;
    }
    public Node(K value){
        this.value = value;
        this.next  =null;
    }
}
class SingularLinkedList<K> implements LinkedList<K>{
    Node<K> head;
    public SingularLinkedList(){
        this.head = new Node<K>();
    }
    @Override
    public void add(K item) {
        Node<K> ptr = head;
        while(ptr.next != null){
            ptr = ptr.next;
        }
        ptr.next = new Node<K>(item);
    }

    @Override
    public void remove(K item) {
        Node<K> ptr = head,prev = null;
        while(ptr!= null && ptr.value != item){
            prev = ptr;
            ptr = ptr.next;
        }
        if(prev == null){
            head = head.next;
        }else{
            prev.next = ptr.next;
        }
    }
    @Override
    public Node<K> get(K value) {
        Node<K> ptr = head;
        while(ptr != null && ptr.value != value){
            ptr = ptr.next;
        }
        return ptr;
    }
    public void display(){
        Node<K> ptr = head.next;
        while(ptr != null){
            System.out.println(" "+ptr.value);
            ptr = ptr.next;
        }
    }
}


class SingularLinkedListTest{
    public static void main(String[] args) {
        SingularLinkedList<Integer> list = new SingularLinkedList<Integer>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.remove(3);
        list.display();
        
    }
}


class DNode<K> extends ListNode{
    public K value;
    public DNode<K> prev,next;
    public DNode(){
        this.value = null;
        this.prev = this.next = null;
    }
    public DNode(K value){
        this.value = value;
        this.prev = this.next = null;
    }
}
class DoubleLinkedList<K> implements LinkedList<K>{
    DNode<K> head,tail;
    Map<K,DNode<K>> map;
    public DoubleLinkedList(){
        this.head = new DNode<K>();
        this.tail = new DNode<K>();
        this.map = new HashMap<>();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    @Override
    public void add(K item) {
        if(map.containsKey(item)){
            remove(item);
        }
        DNode<K> prev = tail.prev;
        DNode<K> node = new DNode<K>(item);
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
        map.put(item, node);
    }

    @Override
    public void remove(K item) {
        if(!map.containsKey(item)) return;
        DNode<K> node = map.get(item);
        DNode<K> prev = node.prev,next = node.next;
        prev.next = next;
        next.prev = prev;
        map.remove(item);
    }

    @Override
    public DNode<K> get(K value) {
        return map.get(value);
    }
    public void display(){
        DNode<K> ptr = head.next;
        System.out.println();
        while(ptr != null){
            System.out.print("->"+ptr.value);
            ptr = ptr.next;
        }
        System.out.println();
    }
}

class DoubleLinkedListTest{
    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.display();
        list.remove(2);
        list.display();
        list.add(2);
        list.display();
    }
}
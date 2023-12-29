

import java.util.HashMap;
import java.util.Map;

public class DoubleList {
    class Node{
        public int key,value;
        public Node prev,next;
        public Node(){
            this.key = -1;
            this.value = 0;
            this.prev = null;
            this.next = null;
        }
        public Node(int key,int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    Node FRQ,END,INS;
    int size;
    Map<Integer,Node> nodes;
    public DoubleList(int cap){
        this.size = cap;
        this.FRQ = new Node();
        this.END = new Node();
        this.INS = new Node();
        this.FRQ.next = this.END;
        this.END.prev = this.FRQ;
        this.INS.next = this.END;
        this.nodes = new HashMap<Integer,Node>();
    }
    public void put(int key,int value) {
        Node New = new Node(key, value);
        Node Next = INS.next;
        Node Prev = Next.prev;
        Prev.next = New;
        New.prev = Prev;
        Next.prev = New;
        New.next = Next;
        nodes.put(key, New);
        INS.next = New;
        print("PUT Key: " + key + " Value: " + value);
    }
    public int get(int key) {
        Node node = nodes.get(key);
        if(FRQ.next != node){
            Node Next = node.next;
            Node Prev = node.prev;
            Next.prev = Prev;
            Prev.next = Next;
            if(node == INS.next){
                INS.next = node.next;
            }
            node.next = FRQ.next;
            node.prev = FRQ;
            FRQ.next = node;
        }
        print("GET key "+key);
        return node.value;
    }
    public static void main(String[] args) {
        DoubleList list = new DoubleList(2);
        list.put(1, 1);
        list.put(2, 2);
        list.get(1);
        list.put(3,3);
        list.get(3);
        list.get(1);

    }
    public void print(String message){
        System.out.println(message);
        Node itr = FRQ.next;

        while(itr!=END){
            if(itr == INS.next) System.out.println("This is Insert First Value");
            System.out.println(itr.key+" "+itr.value);
            itr = itr.next;
        }
    }
}

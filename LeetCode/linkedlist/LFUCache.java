package LeetCode.linkedlist;
import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    
    class Node{
        public Node prev,next;
        public int key,value;
        
        public Node() {
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
    
    int size;
    Node FEQ,INS,END;
    Map<Integer,Node> cache;
    public LFUCache(int capacity) {
        this.size=capacity;
        this.FEQ = new Node();
        this.INS = new Node();
        this.END = new Node();
        this.FEQ.next = this.END;
        this.INS.next = this.END;
        this.END.prev = this.FEQ;
        this.cache= new HashMap<Integer,Node>();
    }

    private void add(Node Node){
        Node Next = INS.next;
        Node Prev = Next.prev;
        Prev.next = Node;
        Next.prev = Node;
        Node.prev = Prev;
        Node.next = Next;
        INS.next = Node;
        cache.put(Node.key, Node);
    }
    private void update(Node Node) {
        if(INS.next == Node){
            INS.next = Node.next;
        }
        Node Prev = Node.prev;
        Node Next = Node.next;
        Prev.next = Next;
        Next.prev = Prev;
        add(Node);
    }
    private void delete(){
        Node Node = END.prev;
        if(INS.next == Node){
            INS.next = Node.next;
        }
        Node Prev = Node.prev;
        Prev.next = END;
        END.prev = Prev;
        cache.remove(Node.value);
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node != null){
            if(FEQ.next != node){
                Node Next = node.next;
                Node Prev = node.prev;
                Next.prev = Prev;
                Prev.next = Next;
                if(node == INS.next){
                    INS.next = node.next;
                }
                Next = FEQ.next;
                node.next = Next;
                node.prev = FEQ;
                FEQ.next = node;
                Next.prev = node;
            }
            // print("GET: "+key);
            return node.value;
        }else{
            // print("GET: "+key+ " NULL");
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(!cache.containsKey(key)){
            if(cache.size() == size){
                delete();
            }
            Node New = new Node(key, value);
            add(New);
        }else{
            Node node = cache.get(key);
            node.value = value;
            update(node);
        }
        // print("PUT "+key);
    }
    public static void main(String[] args) {
        LFUCache obj = new LFUCache(2);
        obj.put(1,1);
        obj.print();
        obj.put(2,2);
        obj.print();
        obj.get(1);
        obj.print();
        obj.put(3, 3);
        obj.print();
        System.out.println(obj.get(2));
        System.out.println(obj.get(3));
        obj.put(4,4);
        obj.print();
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
    }
    public void print(){
        Node itr = FEQ.next;
        System.out.println("List:");
        while(itr.next != null){
            System.out.print(itr.key+"->"+itr.value+", ");    
            itr = itr.next;
        }
        System.out.println();
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
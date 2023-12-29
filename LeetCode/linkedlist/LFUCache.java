import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

class LFUCache {
    /* To determine the least frequently used key, a use counter is maintained for each key in the cache. 
    The key with the smallest use counter is the least frequently used key.
    When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). 
    The use counter for a key in the cache is incremented either a get or put operation is called on it. */
    class Node{
        public Node prev,next;
        public int key,value,counter;
        public Node() {
            this.key=-1;
            this.value=-1;
            this.counter = 1;
            this.prev = this.next = null;
        }
        public Node(int key,int value) {
            this.key=key;
            this.value=value;
            this.counter = 1;
            this.prev = this.next = null;
        }
    }
    int size;
    Map<Integer,Node> nodes;
    SortedMap<Integer,Node> cache;
    //Initializes the object with the capacity of the data structure.
    public LFUCache(int capacity) {
        this.size = capacity;
        this.nodes = new HashMap<Integer,Node>();
        this.cache = new TreeMap<Integer,Node>();
    }
    //Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
    public int get(int key) {
        if(nodes.containsKey(key)){
            Node node = nodes.get(key);
            update(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(size == 0) return;
        if(nodes.containsKey(key)){
            Node node = nodes.get(key);
            node.value = value;
            update(node);
        }else{
            if(size == nodes.size()){
                int freq = cache.firstKey();
                delete(freq,null);
            }
            Node node = new Node(key,value);
            insert(1,node);
            nodes.put(key,node);
        }
    }
    public void insert(int freq, Node node){
        if(!cache.containsKey(freq)){
            create(freq);
        }
        Node head = cache.get(freq);
        Node next = head.next;
        node.next = next;
        node.prev = head;
        next.prev = node;
        head.next = node;
    }
    public void create(int freq){
        Node head = new Node();
        head.next = head;
        head.prev = head;
        cache.put(freq, head);
    }
    public void delete(int freq,Node node){
        boolean forRemoval = node == null;
        Node head = cache.get(freq);
        if(node == null){
            node = head.prev;
        }
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        if(prev == next){
            cache.remove(freq);
        }
        if(forRemoval) nodes.remove(node.key);
    }
    public void update(Node node){
        int freq = node.counter;
        delete(freq,node);
        freq += 1;
        node.counter = freq;
        insert(freq,node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
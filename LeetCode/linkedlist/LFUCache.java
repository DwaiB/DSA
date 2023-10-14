package LeetCode.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    
    class Node{
        public Node prev,next;
        public int data;
        
        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
        public Node(Node prev, Node next, int data) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
        
    }

    Map<Integer,Node> cache;
    Node FEQ,INS,END;
    int size;

    public LFUCache(int capacity) {
        this.size=capacity;
        this.cache=new HashMap<Integer,Node>();
        this.FEQ = new Node(0);
        this.INS = new Node(0);
        this.END = new Node(0);
        this.FEQ.next = this.END;
        this.INS.next = this.END;
        this.END.prev = this.FEQ;
    }
    
    public int get(int key) {
        return 0;
    }
    
    public void put(int key, int value) {
        if(!cache.containsKey(key)){
            
            insert(key,value);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
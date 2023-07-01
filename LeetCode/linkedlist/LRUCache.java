import java.util.HashMap;
import java.util.Map;


class LRUCache {
    class DNode{
        int key,value;
        DNode next;
        DNode prev;
        DNode(){}
        DNode(int key,int value){
            this.key = key;
            this.value = value;
            this.next= null;
            this.prev= null;
        }
    }
    DNode head,tail;
    Map<Integer,DNode> cacheMap = new HashMap<Integer,DNode>();
    int size;
    public LRUCache(int capacity) {
        size = capacity;
        head = new DNode();
    }
    
    public int get(int key) {
        if(cacheMap.containsKey(key)){
            SwapNodeToStart(key);
            return cacheMap.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            DNode node = cacheMap.get(key);
            node.value = value;
            SwapNodeToStart(key);
        }
        else{
            InsertNode(key,value);
        }
    }

    public void SwapNodeToStart(int key){
        DNode iNode = cacheMap.get(key);
        if(iNode == head) return;
        if(iNode.next!=null){
            iNode.next.prev = iNode.prev;
        }
        if(iNode.prev!=null){
            iNode.prev.next = iNode.next;
        }
        iNode.prev = null;
        iNode.next = head;
        if(head!=null){
            head.prev = iNode;
        }
        head = iNode;   
        cacheMap.put(key, head);   
    }
    public void InsertNode(int key, int value){
        if(cacheMap.size()== size){
            DeleteNodeFromEnd();
        }
        DNode temp = new DNode(key, value);
        temp.prev = null;
        temp.next = head;
        if(head != null){
            head.prev = temp;
        }
        head = temp;
        cacheMap.put(key, head);
    }
    public void DeleteNodeFromEnd(){
        DNode itr = head;
        display(head);
        while(itr.next!=null && itr.next.next!=null){
            itr = itr.next;
        }
        if(itr.next!=null){
            cacheMap.remove(itr.next.key);
            itr.next = null;
        }
        else if(itr.key == head.key){
            cacheMap.remove(itr.key);
            head = null;
        }
    }

    public static void main(String[] args) {
        int capacity=1;
        LRUCache obj = new LRUCache(capacity);
        
        obj.put(2,1);
        int param_1 = obj.get(2);
        System.out.println("Result Key: 2:"+param_1);
        obj.put(3,2);
        param_1 = obj.get(2);
        System.out.println("Result Key: 2:"+param_1);
        param_1 = obj.get(3);
        System.out.println("Result Key: 3:"+param_1);
        obj.display(obj.head);
    }
    public void display(DNode head){
        DNode temp = head;
        while(temp!=null){
            System.out.println("Node: "+temp.key+":"+temp.value);
            temp = temp.next;
        }
    }
}




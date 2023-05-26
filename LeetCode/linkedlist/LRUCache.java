import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class DNode{
        int key,value;
        int size;
        DNode next;
        DNode prev;
        DNode(int capacity){
            size = capacity;
            next = null;
            prev = null;
        }
        DNode(int key,int value,int size){
            this.key = key;
            this.value = value;
            this.size = size;
            this.next = null;
            this.prev = null;
        }
        DNode(int key,int value,int size,DNode prev,DNode next){
            this.key = key;
            this.value = value;
            this.size = size;
            this.next = next;
            this.prev = prev;
        }
    }
    DNode head;
    Map<Integer,DNode> cacheMap = new HashMap<Integer,DNode>();
    int count;
    public LRUCache(int capacity) {
        head = new DNode(capacity);
        count = 0;
    }
    
    public int get(int key) {
        if(cacheMap.containsKey(key)){
            DNode node = cacheMap.get(key);
            SwapNodeToStart(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            DNode node = cacheMap.get(key);
            node.value = value;
            SwapNodeToStart(node);
        }
        else{
            InsertNode(key,value);
        }
    }

    public void SwapNodeToStart(DNode iNode){
        DNode prev = iNode.prev;
        DNode next = iNode.next;
        if(prev!=null){
            prev.next = next;
        }
        if(next!=null){
            next.prev = prev;
        }
        iNode.prev = null;
        iNode.next = head;
        head.prev = iNode;
        head = iNode;      
    }
    public void InsertNode(int key, int value){
        if(count == head.size){
            System.out.println("Count== Size : Deleting Last Node "+count);
            DeleteNodeFromEnd();
        }
        if(head.key == 0 && count == 0){
            System.out.println("Inserting new Node "+key);
            head = new DNode(key, value, head.size);
        }
        else{
            DNode node = new DNode(key, value, head.size, null, head);
            head.prev = node;
            head = node;
        }
        System.out.println("Inserted Node "+key);
        if(head.prev!=null)
            System.out.println("Previous Node "+head.prev.key);
        if(head.next!=null){
            System.out.println("Next Node "+head.next.key);
        }
        count++;
        System.out.println("Count after Insertion "+count);
        cacheMap.put(key, head);
    }
    public void DeleteNodeFromEnd(){
        if(head.size == 1){
            System.out.println("Head is Last Node");
            cacheMap.remove(head.key);
            head = new DNode(0, 0, head.size);
            count = 0;
            return;
        }
        DNode itr = head;
        DNode prev=itr;
        while(itr.next!=null){
            prev= itr;
            itr = itr.next;
        }
        if(prev!=null){
            prev.next = itr.next;
        }
        if(itr.next!=null){
            itr.next.prev = itr.prev;
        }
        System.out.println("Count after Delete "+count);
        count--;
        cacheMap.remove(itr.key);
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
            System.out.print("Node: "+temp.key+":"+temp.value);
            if(temp.prev!=null){
                System.out.println(" Previous Node "+temp.prev.key);
            }
            System.out.println();
            temp = temp.next;
        }
    }
}




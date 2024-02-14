package Java.DSA.Heap;

public class PriorityHeap{
    int [] TREE;
    int N;
    public PriorityHeap(int N){
        this.TREE = new int[N+1];
        this.N = 0;
    }
    public void offer(int item){
        if(N+1 == TREE.length) {
            System.out.println("OVERFLOW");
            return;
        }
        N = N + 1;
        int ptr = N;
        while(ptr > 1){
            int par = ptr/2;
            if(item <= TREE[par]){
                TREE[ptr] = item;
                return;
            }
            TREE[ptr] = TREE[par];
            ptr = par;
        }
        TREE[1] = item;
    }
    public int poll(){
        if(N == -1){
            System.out.println("UNDERFLOW");
            return -1;
        }
        int item = TREE[1];
        int ptr = 1;
        int last = TREE[N];
        N = N - 1;
        int left = 2,right = 3;
        while(right <= N){
            if(last >= TREE[left] && last >= TREE[right]){
                TREE[ptr] = last;
                return item;
            }
            if(TREE[right] <= TREE[left]){
                TREE[ptr] = TREE[left];
                ptr = left;
            }else{
                TREE[ptr] = TREE[right];
                ptr = right;
            }
            left = ptr*2;
            right = left+1;
        }
        if(left == N && last < TREE[left]){
            TREE[ptr] = TREE[left];
            ptr = left;
        } 
        TREE[ptr] = last;
        return item;
    }
    public int peek(){
        if(N == -1){
            System.out.println("NULL");
            return -1;
        }
        return TREE[1];
    }
    public void display(){
        System.out.print("HEAP ");
        for(int i=1;i<=N;++i){
            System.out.print("  "+TREE[i]);
        }
        System.out.println();
    }
}
class PriorityHeapTest{
    public static void main(String[] args) {
        PriorityHeap heap = new PriorityHeap(20);
        System.out.println("Inserting 2");
        heap.offer(2);
        System.out.println("Inserting 3");
        heap.offer(3);
        System.out.println("Inserting 4");
        heap.offer(4);
        heap.display();
        System.out.println("Remove from heap "+heap.poll());
        System.out.println("Top of heap "+heap.peek());
        heap.display();
        System.out.println("Inserting 1");
        heap.offer(1);
        heap.display();
        System.out.println("Remove from heap "+heap.poll());
        heap.display();
        System.out.println("Remove from heap "+heap.poll());
        heap.display();
        System.out.println("Remove from heap "+heap.poll());
        heap.display();
        System.out.println("Inserting 6");
        heap.offer(6);
        System.out.println("Inserting 4");
        heap.offer(4);
        System.out.println("Remove from heap "+heap.poll());
        System.out.println("Top of heap "+heap.peek());
        heap.display();
    }
}
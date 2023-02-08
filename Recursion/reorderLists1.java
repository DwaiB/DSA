

public class reorderLists1 {
    public static void reorderList(ListNode head) {
        if(head.next == null) return;
        ListNode stackBottom = head.next,stackTop = head.next,next = null,prev = null,backup = new ListNode();
        int size = 0;
        stackBottom = backup;
        while(stackTop!=null) {
            backup.next = stackTop;
            backup = backup.next;
            size++;
            next = stackTop.next;
            stackTop.next = prev;
            prev = stackTop;
            stackTop = next;
        }
        System.out.println(size);
        
        stackTop = prev;
        display(backup);
        display("StackBottom",stackBottom);
        display("Stacktop", stackTop);
        prev = head;
        int a = (size/2)-1, b = (size/2);
        while(a>=0){
            prev.next = stackTop;
            System.out.println(a);
            prev = prev.next;
            prev.next = stackBottom;
            
            prev = prev.next;
            a--;
            stackTop = stackTop.next;
            stackBottom = stackBottom.next;
        }
        stackTop.next = null;
        prev.next= stackTop;

        display("Stacktop", stackTop);
    }
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode curr = head;
        for(int i=1;i<=10;i++){
            curr.val = i;
            curr.next = new ListNode();
            curr = curr.next;
        }
        curr.val = 11;
        display("Initial",head);
        reorderList(head);
        
        display("Modified",head);
    }
    public static void display(String str,ListNode list){
        System.out.println("-----"+str+" List-----");
        while(list!=null){
            System.out.print(list.val+"->");
            list = list.next;
        }
        System.out.println();
    }
    public static void display(ListNode list){
        System.out.println("----- List-----");
        while(list!=null){
            System.out.print(list.val+"->");
            list = list.next;
        }
        System.out.println();
    }
}

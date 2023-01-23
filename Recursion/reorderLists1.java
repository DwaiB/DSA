import java.util.ArrayList;
import java.util.List;

public class reorderLists1 {
    public static void reorderList(ListNode head) {
        if(head.next == null) return;
        ListNode stackBottom = head,stackTop = head.next.next;
        ListNode currB = stackBottom;
        while(currB.next!=null && stackTop.next!=null) {

        }
        
    }
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode curr = head;
        for(int i=0;i<10;i++){
            curr.val = i;
            curr.next = new ListNode();
            curr = curr.next;
        }
        curr.val = 10;
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
}

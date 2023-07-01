import java.util.ArrayList;
import java.util.List;

public class reorderLists {
    public static void reorderList(ListNode head) {
        if(head.next == null) return;
        ListNode stackBottom = head,stackTop = head.next;
        List<ListNode> stack = new ArrayList<ListNode>();
        while(stackTop!=null){
            stack.add(stackTop);
            stackTop = stackTop.next;
        }
        int i=0,j=stack.size()-1;
        while(i<j){
            stackBottom.next=stack.get(j--);
            stackBottom.next.next = stack.get(i++);
            stackBottom = stackBottom.next.next;
        }
        if(stack.size()%2==0)stackBottom.next=stack.get(j);
        else stackBottom.next=stack.get(i);
        stackBottom.next.next=null;
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
        display(head);
        reorderList(head);
        
        display(head);
    }
    public static void display(ListNode list){
        while(list!=null){
            System.out.print(list.val+"->");
            list = list.next;
        }
        System.out.println();
    }
}

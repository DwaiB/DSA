public class reverseList {
    public static void reverseAList(ListNode head){
        ListNode curr = head,prev = null,next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        display("head", head);
        display("rev", prev);
    }
    public ListNode reverse(ListNode head,ListNode prev,int index){
        if(index == 0){
            return prev;
        }
        ListNode temp = head;
        ListNode next = head.next;
        temp.next = prev;
        return reverse(next, head, index-1);
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
        reverseAList(head);
        
        display("Reversed",head);
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

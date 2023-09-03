package Java.DSA.LinkedList;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public static void print(ListNode head,String msg){
        System.out.println(msg);
        while(head!=null){
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println("\n ------");
    }
    public static ListNode newList(int [] arr){
        ListNode head = null,ptr = null;
        for(int i =0; i < arr.length;i++){
            if(head == null){
                head = new ListNode(arr[i]);
                ptr = head;
            }
            else{
                ptr.next = new ListNode(arr[i]);
                ptr = ptr.next;
            }
        }
        return head;
    }
}
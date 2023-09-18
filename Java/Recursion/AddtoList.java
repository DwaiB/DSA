package Java.Recursion;
public class AddtoList {
    public ListNode position(ListNode tempR,ListNode tempH){
        if(tempH == null){
            return tempH;
        }
        ListNode temp;
        if(tempR != null){
            temp = tempR;
            System.out.println("If Value: "+temp.val);
            temp.next = position(tempR.next, tempH);
        }
        else{
            temp = tempH;
            System.out.println("Else Value: "+temp.val);
            temp.next = position(tempR, tempH.next);
        }
        
        return temp;
    }

    public static void main(String[] args) {

        AddtoList RKN = new AddtoList();

        ListNode head = new ListNode();
        ListNode curr = head;
        for(int i=0;i<5;i++){
            curr.val = i;
            curr.next = new ListNode();
            curr = curr.next;
        }
        curr.val = 5;
        ListNode head2 = new ListNode();
        curr = head2;
        for(int i=6;i<10;i++){
            curr.val = i;
            curr.next = new ListNode();
            curr = curr.next;
        }
        curr.val = 10;
        RKN.display("TEMP1", head);
        RKN.display("TEMP2", head2);
        ListNode res = RKN.position(head, head2);
        RKN.display("result", res);
    }

    public void display(String str,ListNode list){
        System.out.println("-----"+str+" List-----");
        while(list!=null){
            System.out.print(list.val+"->");
            list = list.next;
        }
        System.out.println();
    }
}

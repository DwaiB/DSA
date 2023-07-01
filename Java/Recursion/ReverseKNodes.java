import java.util.Stack;

public class ReverseKNodes {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> nodes = new Stack<ListNode>();
        // return recurse(head, nodes, k, 1);
        
        return head;
    }

    public ListNode recurse(ListNode head,Stack<ListNode> revNode, int k, int index) {
        if(head == null) return head;
        ListNode tempH = head,tempR=null;
        if(index%k!=0){
            revNode.push(tempH);
        }
        if(index%k==0){
            revNode.push(tempH);
            tempR = reverse(revNode);
            revNode = new Stack<>();
        }
        tempH.next = recurse(head.next, revNode, k, index+1);
        if(tempR!=null){
        }
        return tempH;
    }
    public ListNode reverse(Stack<ListNode> stack){
        if(stack.size()==0){
            return null;
        }
        ListNode temp = new ListNode();
        temp = stack.pop();
        temp.next = reverse(stack);
        return temp;
    }
    public ListNode position(ListNode tempR,ListNode tempH){
        if(tempH == null){
            return tempH;
        }
        ListNode temp;
        if(tempR != null){
            temp = tempR;
            temp.next = position(tempR.next, tempH);
        }
        else{
            temp = tempH;
            temp.next = position(tempR, tempH.next);
        }
        return temp;
    }



    public static void main(String[] args) {

        ReverseKNodes RKN = new ReverseKNodes();

        ListNode head = new ListNode();
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode curr = head;
        for(int i=1;i<5;i++){
            curr.val = i;
            stack.push(curr);
            curr.next = new ListNode();
            curr = curr.next;
            
        }
        curr.val = 5;
        
        RKN.display("result", head);
        ListNode res  = RKN.reverse(stack); 
        // ListNode res = RKN.reverseKGroup(head, 2);
        RKN.display("result", res);
        RKN.display("result", head);
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

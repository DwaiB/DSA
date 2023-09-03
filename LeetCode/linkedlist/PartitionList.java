import java.util.Scanner;

import Java.DSA.LinkedList.ListNode;

class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;
        ListNode less = null, more = null, next,ptr=head,itr= null;

        // if(ptr.val < x){
        //     next = ptr.next;
        //     less = insert(less, ptr);
        //     head = next;
        //     ptr = head;
        // }
        while(ptr!= null){
            next = ptr.next;
            if(ptr.val < x){
                less = insert(less, ptr);
            }
            else if(ptr.val >= x){
                more = insert(more,ptr);
            }
            ptr = next;
        }
        ListNode.print(less,"Less");
        ListNode.print(more,"More");
        ListNode.print(head,"Head");

        itr = less;
        while (itr!=null && itr.next!=null){
            itr = itr.next;
        }
        if(itr != null){
            itr.next = more;
            head = less;
        }
        return head;
    }



    public ListNode insert(ListNode main, ListNode item){
        item.next = null;
        if(main == null){
            return item;    
        }
        ListNode ptr = main;
        while(ptr.next!=null){
            ptr = ptr.next;
        }
        ptr.next = item;
        return main;
    }



    


    public static void main(String[] args) {
        PartitionList pt = new PartitionList();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("\nLength: ");
            int l = sc.nextInt();
            if( l == -1){
            break;  
            }
            System.out.println("Array: ");
            String s = sc.next();
            String []  sr = s.split(",");
            int [] arr = new int [sr.length];
            for(int i = 0; i < sr.length;i++) arr[i] = Integer.parseInt(sr[i]);
            System.out.print("\nTarget: ");
            int x = sc.nextInt();
            ListNode head = ListNode.newList(arr);
            head = pt.partition(head,x);
            ListNode.print (head,"Result");
        }
        sc.close();
    }

}
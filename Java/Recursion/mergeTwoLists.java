class mergeTwoLists {
    public static ListNode mergeTwoList(ListNode list1, ListNode list2) {   
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode result = new ListNode();
        if(list1.val < list2.val) {
            result.val = list1.val;
            result.next = mergeTwoList(list1.next, list2);
        }
        else if(list1.val > list2.val) {
            result.val = list2.val;
            result.next = mergeTwoList(list1, list2.next);
        }
        else{
            result.val = list1.val;
            result.next = new ListNode();
            result.next.val = list1.val;
            result.next.next = mergeTwoList(list1.next, list2.next);
        }
        return result;
    }
    public static void main(String[] args) {
        //Declare
        ListNode list1 = new ListNode();
        ListNode list2 = new ListNode();
        ListNode list3 = new ListNode();
        //Initialize list1
        list3.val = 1;
        list1.val = 10;
        list1.next = new ListNode();
        list1.next.val = 20;
        list1.next.next = new ListNode();
        list1.next.next.val = 30;
        //Initialize list2
        list2.val = 11;
        list2.next = new ListNode();
        list2.next.val = 19;
        list2.next.next = new ListNode();
        list2.next.next.val = 31;


        //Call merge
        list3.next = mergeTwoList(list1,list2);
        
        //Display lists
        System.out.println("List1");
        display(list1);
        System.out.println();
        System.out.println("List2");
        display(list2);
        System.out.println();
        System.out.println("List3");
        display(list3);
    }
    public static void display(ListNode list){
        while(list!=null){
            System.out.print(list.val+"->");
            list = list.next;
        }
    }
}
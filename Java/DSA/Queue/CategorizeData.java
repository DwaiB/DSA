package Java.DSA.Queue;

import java.util.Scanner;

public class CategorizeData {
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    Node q0to9,q10to19,q20to29,qto100;
    CategorizeData(){
        q0to9 = new Node(0);
        q10to19 = new Node(0);
        q20to29 = new Node(0);
        qto100 = new Node(0);
        q0to9.next = q10to19;
        q10to19.next = q20to29;
        q20to29.next = qto100;
    }
    public void insert(int item){
        Node temp;
        Node node = new Node(item);
        if(item<10){
            temp = q0to9.next;
            node.next = temp;
            q0to9.next = node;
        }
        else if(item>9 && item<20){
            temp = q10to19.next;
            node.next = temp;
            q10to19.next = node;
        }
        else if(item>19 && item<29){
            temp = q20to29.next;
            node.next = temp;
            q20to29.next = node;
        }
        else{
            temp = qto100.next;
            node.next = temp;
            qto100.next = node;
        }
    }
    public void show(){
        Node temp = q0to9.next;
        System.out.println();
        while(temp!=null){
            if(temp == q10to19 || temp == q20to29 || temp == qto100){
                temp = temp.next;
                continue;
            }
            System.out.println(temp.val);
            temp = temp.next;
            
        }
    }
    public static void main(String[] args) {
        CategorizeData data = new CategorizeData();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            logger.log("Age List:");
            logger.log("1: Insert");
            logger.log("2: Show ");
            logger.log("4: Exit");
            choice = sc.nextInt();
            int item;
            switch (choice) {
                case 1: logger.log("Enter Weight :");
                        item = sc.nextInt();
                        data.insert(item);
                        break;
                case 2: data.show();
                        break;
                default: logger.log("Exit");
            }
        }
        sc.close();
    }
}

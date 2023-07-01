package Java.DSA.Queue;

import java.util.Scanner;

class logger {
    static void log(String message) {
        System.out.println(message);
    }
}

public class PriorityQueue{
    static Scanner sc ;
    

    class Node {
        int val,weight;
        Node prev, next;

        Node(int val,int weight) {
            this.val = val;
            this.weight = weight;
            prev = next = null;
        }
    }

    Node front, rear;

    PriorityQueue() {
        front = new Node(0,0);
        rear = new Node(0,0);
        front.next = rear;
        rear.prev = front;
    }

    Node pop_out() {
        if (front.next == rear) {
            return new Node(0,0);
        }
        Node fNode = front.next;
        front.next = fNode.next;
        return fNode;
    }

    void insert(int val,int weight) {
        Node node = new Node(val,weight);
        Node temp = front.next;
        while(temp!=rear && temp.weight<=weight){
            temp = temp.next;
        }
        Node prev = temp.prev, next = temp;
        prev.next = next.prev = node;
        node.prev = prev;
        node.next = next;
    }

    void show() {
        Node temp = front.next;
        System.out.print("Queue: \n");
        System.out.print("Weight:\t");
        while (temp != rear) {
            System.out.print(temp.weight+"\t");
            temp = temp.next;
        }temp = front.next;
        System.out.print("\nValue:\t");
        while (temp != rear) {
            System.out.print(temp.val+"\t");
            temp = temp.next;
        }
        System.out.println("\n-------------------------------\n");
    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        sc = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            logger.log("Queue List:");
            logger.log("1: Insert");
            logger.log("2: Delete");
            logger.log("3: Show ");
            logger.log("4: Exit");
            choice = sc.nextInt();
            int item,weight;
            switch (choice) {
                case 1: logger.log("Item : \b1");

                        item = sc.nextInt();
                        logger.log("Weight of : "+item);
                        weight = sc.nextInt();
                        queue.insert(item,weight);
                        break;
                case 2: Node temp = queue.pop_out();
                logger.log("Deleting First Priority : "+temp.weight+ " Value : " + temp.val);
                        break;
                case 3: queue.show();
                        break;
                default: logger.log("Exit?");
            }
        }
    }

    @Override
    protected void finalize(){
        sc.close();
    }

}

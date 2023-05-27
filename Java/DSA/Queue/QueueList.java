package Java.DSA.Queue;

import java.util.Scanner;

class logger {
    static void log(String message) {
        System.out.println(message);
    }
}

public class QueueList {
    static Scanner sc ;
    

    class Node {
        int val;
        Node prev, next;

        Node(int val) {
            this.val = val;
            prev = next = null;
        }
    }

    Node front, rear;

    QueueList() {
        front = new Node(0);
        rear = new Node(0);
        front.next = rear;
        rear.prev = front;
    }

    int pop_out() {
        if (front.next == rear) {
            return -1;
        }
        Node fNode = front.next;
        front.next = fNode.next;
        return fNode.val;
    }

    void insert(int val) {
        Node node = new Node(val);
        Node prev = rear.prev, next = rear;
        prev.next = next.prev = node;
        node.prev = prev;
        node.next = next;
    }

    void show() {
        Node temp = front.next;
        System.out.print("Queue: \n> ");
        while (temp != rear) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println("\n================\n");
    }
    public static void main(String[] args) {
        QueueList queue = new QueueList();
        sc = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            logger.log("Queue List:");
            logger.log("1: Insert");
            logger.log("2: Delete");
            logger.log("3: Show ");
            logger.log("4: Exit");
            choice = sc.nextInt();
            int item;
            switch (choice) {
                case 1: logger.log("Item : ");
                        item = sc.nextInt();
                        queue.insert(item);
                        break;
                case 2: logger.log("Deleting Item : "+queue.pop_out());
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

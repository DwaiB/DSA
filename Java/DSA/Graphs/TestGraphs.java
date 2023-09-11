package Java.DSA.Graphs;

import java.util.Scanner;

public class TestGraphs {
    public static void main(String[] args) {
        Graph<String> gs = new LinkedGraph<String>(15);
        gs.INSNODE("Kolkata");
        gs.INSNODE("Mumbai");
        gs.INSNODE("New Delhi");
        gs.INSNODE("Bangalore");
        gs.INSNODE("Pune");
        gs.INSNODE("Chennai");
        gs.INSNODE("Hyderabad");
        gs.INSEDGE("Kolkata", "Mumbai");
        gs.INSEDGE("New Delhi", "Kolkata");
        gs.INSEDGE("New Delhi", "Hyderabad");
        gs.INSEDGE("Hyderabad", "Bangalore");
        gs.INSEDGE("Bangalore", "Kolkata");
        gs.INSEDGE("Mumbai", "New Delhi");
        gs.INSEDGE("Pune", "Chennai");
        gs.INSEDGE("Chennai", "Pune");
        // gs.DELEDGE("Kolkata", "Mumbai");
        // gs.DELNODE("Pune");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String choice;
            System.out.println("Cities : \nKolkata\tNew Delhi\tMumbai\nPune\tBangalore\tHyderabad\nChennai\n");
            System.out.println("Enter Origin City");
            System.out.println("Enter Destination City");
            System.out.println("Press E or Exit to quit");
            choice = sc.next();
            if (choice.equalsIgnoreCase("Exit") || choice.equalsIgnoreCase("E")) {
                break;
            }
            String a = choice;
            String b = sc.next();
            if (gs.DFS(a, b)) {
                System.out.println("Route Exists");
            }else{
                System.out.println("No Routes Exists");
            }

        }
        System.out.println("Size of Graph "+gs.SIZE());
        sc.close();
    }
}

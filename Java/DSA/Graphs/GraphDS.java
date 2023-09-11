package Java.DSA.Graphs;

import java.util.Scanner;

public class GraphDS {
    String[] NODE,DEST;
    int[] NEXT,ADJ,LINK;
    int START,AVAILN,AVAILE;
    public GraphDS(){
        START = -1;
        AVAILN = 0;
        AVAILE = 0;
        NODE = new String[15];
        DEST = new String[15];
        NEXT = new int[15];
        ADJ  = new int[15];
        LINK = new int[15];
    }
    public void INIT(){
        for(int i = 0;i<15-1;i++){
            NEXT[i] = i+1;
            LINK[i] = i+1;
        }
        NEXT[14] = -1;
        LINK[14] = -1;
    }

    public int FIND(String[] info, int[] link, int start, String item,int loc){
        int ptr = start;
        while(ptr != -1){
            if(item.equals(info[ptr])){
                loc = ptr;
                break;
            }
            ptr = link[ptr];
        }
        return loc;
    }
    public boolean DELETE(String [] info,int[] link, int start, int avail, String item,boolean flag){
        if(start == -1){
            return flag;
        }
        int ptr,save;
        if((item.equals(info[start]))){
            ptr = start;
            start = link[start];
            link[ptr] = avail;
            avail = ptr;
            flag = true;
        }else{
            ptr = link[start];
            save = start;
            while(ptr != -1){
                if(item.equals(info[ptr])){
                    link[save] = link[ptr];
                    link[ptr] = avail;
                    avail = ptr;
                    flag = true;
                    break;
                }
                save = ptr;
                ptr = link[ptr];
            }
        }
        START = start;
        
        return flag;
    }

    public int FINDEDGE(String[] node, int[] next,int[] adj,int start, String[] dest,int[] link,String a, String b, int loc){
        loc = -1;
        int locA = FIND(node,next,start,a,-1);
        int locB = FIND(node,next,start,b,-1);
        if(locA == -1 || locB == -1){
            return loc;
        }
        loc = FIND(dest,link,adj[locA],b,-1);
        return loc;
    }

    public boolean INSNODE(String[] node, int[] next,int[] adj, int start, int avail,String n, boolean flag){
        if(avail == -1){
            return flag;
        }
        adj[avail] = -1;
        int curr = avail;
        avail = next[avail];
        node[curr] = n;
        next[curr] = start;
        start = curr;
        flag = true;
        START = start;
        AVAILN = avail;
        return flag;
    }

    public boolean INSEDGE(String[] node,int[] next, int[] adj,int start, String[] dest, int[] link, int avail,String a,String b, boolean flag){
        System.out.println("Start "+start+" Avail "+avail+" likn[avail] "+link[avail]+" ORG "+a+" Dest "+b);
        int locA = FIND(node,next,start,a,-1);
        int locB = FIND(node,next,start,b,-1);
        System.out.println("LocA " +locA+" LocB "+locB );
        if(avail == -1){
            flag = false;
        }else{
            int curr = avail;
            avail = link[avail];
            dest[curr] = node[locB];
            link[curr] = adj[locA];
            adj[locA] = curr;
            flag = true;
        }
        AVAILE = avail;
        return flag;
    }

    public boolean DELEDGE(String[] node,int[] next,int[] adj,int start, String [] dest, int[] link,int avail,String a, String b, boolean flag){
        int locA = FIND(node,next,start,a,-1);
        int locB = FIND(node,next,start,b,-1);
        flag = DELETE(dest,link,adj[locA],avail,node[locB],false);
        return flag;
    }
    public boolean DELNODE(String[] node, int[] next,int[] adj, int start,int availn, String[] dest, int[] link, int availe,String n,boolean flag){
        int loc = FIND(node,next,start,n,-1);
        if(loc == -1){
            flag = false;
            return flag;
        }
        int ptr = start;
        while(ptr != -1){
            DELETE(dest,link,adj[ptr],availe,node[loc],flag);
            ptr =next[ptr];
        }
        if(adj[loc] != -1){
            int beg = adj[loc];
            int end = adj[loc];
            ptr = link[end];
            while(ptr != -1){
                end = ptr;
                ptr = link[ptr];
            }
            link[end] = availe;
            availe = beg;
        }
        DELETE(node,next,loc,availn,n,flag);
        flag = true;
        return flag;
    }
    public void FILL(){
        INSNODE(NODE, NEXT, ADJ, START, AVAILN, "Kolkata", false);
        INSNODE(NODE, NEXT, ADJ, START, AVAILN, "New Delhi", false);
        INSNODE(NODE, NEXT, ADJ, START, AVAILN, "Mumbai", false);
        INSNODE(NODE, NEXT, ADJ, START, AVAILN, "Balgalore", false);
        INSNODE(NODE, NEXT, ADJ, START, AVAILN, "Chennai", false);
        INSNODE(NODE, NEXT, ADJ, START, AVAILN, "Pune", false);
        INSNODE(NODE, NEXT, ADJ, START, AVAILN, "Hyderabad", false);

        INSEDGE(NODE, NEXT, ADJ, START, DEST, LINK, AVAILE, "Kolkata", "Mumbai", false);
        INSEDGE(NODE, NEXT, ADJ, START, DEST, LINK, AVAILE, "New Delhi","Kolkata", false);
        INSEDGE(NODE, NEXT, ADJ, START, DEST, LINK, AVAILE, "New Delhi","Hyderabad", false);
        INSEDGE(NODE, NEXT, ADJ, START, DEST, LINK, AVAILE, "Hyderabad", "Balgalore", false);
        INSEDGE(NODE, NEXT, ADJ, START, DEST, LINK, AVAILE, "Balgalore", "Kolkata", false);
        INSEDGE(NODE, NEXT, ADJ, START, DEST, LINK, AVAILE, "Mumbai", "New Delhi", false);
        
        INSEDGE(NODE, NEXT, ADJ, START, DEST, LINK, AVAILE, "Chennai", "Pune", false);
        INSEDGE(NODE, NEXT, ADJ, START, DEST, LINK, AVAILE, "Pune", "Chennai", false);
    }
    public void PRIBOARD(){
        System.out.println("Cities : \nKolkata\tNew Delhi\tMumbai\nPune\tBangalore\tHyderabad\nChennai\n");
        System.out.println("Enter Origin City");
        System.out.println("Enter Destination City");
        System.out.println("Press E or Exit to quit");
    }
    public static void main(String[] args) {
        GraphDS graph = new GraphDS();

        // graph.INIT();
        graph.FILL();
        Scanner sc = new Scanner(System.in);
        while(true){
            String choice;
            graph.PRIBOARD();
            choice = sc.next();
            if(choice.equalsIgnoreCase("Exit") || choice.equalsIgnoreCase("E")){
                break;
            }
            String a = choice;
            String b = sc.next();
            if(graph.FINDEDGE(graph.NODE, graph.NEXT, graph.ADJ, graph.START, graph.DEST, graph.LINK, a, b, 0) != -1){
                System.out.println("Route Exists");
            }

        }
        sc.close();
    }
}

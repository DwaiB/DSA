package LeetCode.graphs;

import java.util.Arrays;

public class CourseScheduleII {
    public int[] findOrder(int n, int[][] pre) {
        int[] nodes = new int[n];
        int[] outdg = new int[n];
        Arrays.fill(nodes,-1);
        Arrays.fill(outdg,0);
        int u,v,ptr;
        for(int i = 0; i < pre.length;i++){
            u = pre[i][0];
            v = pre[i][1];
            outdg[v]++;
            if(nodes[u] != -1){
                ptr = nodes[u];
                while(pre[ptr][0] != -1){
                    ptr = pre[ptr][0];
                }
                pre[ptr][0] = i;
            }else{
                nodes[u] = i;
            }
            pre[i][0] = -1;
        }
        System.out.println("Outdegree: ");
        for(int i=0;i<n;i++){
            System.out.println("for "+i+" = "+outdg[i]);
        }
        int [] queue = new int[n];
        int front = 0,rear = -1;
        for(int i = 0 ; i < nodes.length;i++){
            if(outdg[i] == 0){
                rear++;
                queue[rear] = i;
            }
        }
        if(rear == -1){
            return new int [0];
        }
        System.out.println("Queue: ");
        for(int i=front;i<=rear;i++){
            System.out.println(queue[i]);
        }
        front = 0;
        int poll;
        while(front <= rear){
            poll = queue[front];
            front ++;
            u = nodes[poll];
            if(u == -1) continue;
            while(pre[u][0] != -1){
                v = pre[u][1];
                outdg[v]--;
                if(outdg[v] == 0){
                    rear++;
                    queue[rear] = v;
                }
                u = pre[u][0];
            }
            v = pre[u][1];
            outdg[v]--;
            if(outdg[v] == 0){
                rear++;
                queue[rear] = v;
            }
        }
        System.out.println("Outdegree: After");
        for(int i=0;i<n;i++){
            System.out.println("for "+i+" = "+outdg[i]);
        }
        for(int i = 0;i< n/2;i++){
            if(outdg[i] != 0){
                return new int [0];
            }
            int temp = queue[i];
            queue[i] = queue[n-1-i];
            queue[n-1-i] = temp;
        }
        return queue;
    }
    public static void main(String[] args) {
        CourseScheduleII cs = new CourseScheduleII();
        int[][] pre = new int [5][2];
        int n = 4;
        pre[0][0] = 0;
        pre[0][1] = 1;
        pre[1][0] = 1;
        pre[1][1] = 2;
        pre[2][0] = 2;
        pre[2][1] = 3;
        pre[3][0] = 0;
        pre[3][1] = 2;
        pre[4][0] = 1;
        pre[4][1] = 3;
        // int n = 2;
        // pre[0][0] = 0;
        // pre[0][1] = 1;
        // pre[1][0] = 1;
        // pre[1][1] = 0;
        int [] courses = cs.findOrder(n, pre);
        System.out.println("\nCourses: ");
        for(int i = 0; i < courses.length; i++){
            System.out.print(courses[i]+" ");
        }
    }
}
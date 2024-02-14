package Java.GraphQuestions;

import java.util.Scanner;

public class SumOfInNodes{
    static Scanner sc;
    public void findNodeWithMaxSum(){   
        System.out.print("Size: ");
        int n = sc.nextInt();
        // int[] nodes = new int[n];
        int[] count = new int[n];
        // for(int i=0;i<n;++i){
        //     System.out.print("Node "+i+"->");
        //     nodes[i] = sc.nextInt();
        // }
        int[] nodes = {4,4,1,4,13,8,8,8,0,8,14,9,15,11,-1,10,15,22,22,22,22,22,21};
        for(int i=0;i<n;++i){
            dfs(i,nodes[i],count,nodes,new boolean[n]);
        }
        int res = -1,max = Integer.MIN_VALUE;
        for(int i=0;i<n;++i){
            System.out.println(i+"-> "+count[i]);
            if(max < count[i]){
                max = count[i];
                res = i;
            }
        }
        System.out.println("Result:-\nNode with maximum Indegree Sum: "+res);
    }
    public void dfs(int u,int v,int[] count,int[] nodes,boolean[] vis){
        if(nodes[u] == -1 || vis[u]){
            return;
        }
    }
    public static void main(String[] args) {
        SumOfInNodes main = new SumOfInNodes();
        sc = new Scanner(System.in);
        System.out.print("Test Cases: ");
        int T = sc.nextInt();
        while(--T >=0){
            main.findNodeWithMaxSum();
        }
    }
    
    @Override
    public void finalize(){
        sc.close();
    }
}
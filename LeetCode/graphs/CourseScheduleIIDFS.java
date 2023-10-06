package LeetCode.graphs;

import java.util.Arrays;

public class CourseScheduleIIDFS {
    int rear;
    int[] list;

    public int[] findOrder(int n, int[][] pre) {
        int[] nodes = new int[n];
        Arrays.fill(nodes, -1);

        int u, v, ptr;
        for (int i = 0; i < pre.length; i++) {
            u = pre[i][0];
            v = pre[i][1];
            if (nodes[u] != -1) {
                ptr = nodes[u];
                while (pre[ptr][0] != -1) {
                    ptr = pre[ptr][0];
                }
                pre[ptr][0] = i;
            } else {
                nodes[u] = i;
            }
            pre[i][0] = -1;
        }
        rear = -1;
        list = new int[n];
        int[] visited = new int[n];
        Arrays.fill(visited, 1);
        Arrays.fill(list, -1);

        for (int i = 0; i < n; i++) {
            dfs(n, nodes, pre, i, visited);
        }
        return (rear == n - 1) ? list : new int[0];
    }

    public boolean dfs(int n, int[] nodes, int[][] pre, int i, int[] visited) {
        print("Checking for" + i);
        if (visited[i] == 2) {
            print(i + " In Progress");
            return false;
        }
        if (visited[i] == 3) {
            print("Processed " + i);
            return true;
        }
        visited[i] = 2;
        int u, v;
        u = nodes[i];
        if (u == -1) {
            visited[i] = 3;
            print("No Edges " + i);
            list[++rear] = i;
            return true;
        }

        while (pre[u][0] != -1) {
            v = pre[u][1];
            if (!dfs(n, nodes, pre, v, visited)) {
                print("Edges failed " + v);
                return false;
            }
            u = pre[u][0];
        }
        v = pre[u][1];
        if (!dfs(n, nodes, pre, v, visited)) {
            print("Edges failed " + v);
            return false;
        }
        list[++rear] = i;
        visited[i] = 3;
        print("Passed Node " + i);
        return true;
    }

    public void print(String s) {
        System.out.println(s);
    }
}

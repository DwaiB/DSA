package LeetCode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    List<List<String>> res;

    public void addToList(char[][] dp, int n) {
        List<String> list = new ArrayList<String>();
        String sb = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 'Q') {
                    sb += "Q";
                } else {
                    sb += ".";
                }
            }
            list.add(sb);
            sb = "";
        }
        if(!res.contains(list))
            res.add(list);
    }

    public boolean checkPosition(char[][] dp, int n, int row, int col) {
        int i = 0, j = 0;
        // check row and column
        for (i = 0; i < n; i++) {
            if (dp[row][i] == 'Q' || dp[i][col] == 'Q') {
                return false;
            }
        }
        // left upper diagonal
        i = row - 1;
        j = col - 1;
        while (i >= 0 && j >= 0) {
            if (dp[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        // right upper diagonal
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < n) {
            if (dp[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }
        // left lower diagonal
        i = row + 1;
        j = col - 1;
        while (i < n && j >= 0) {
            if (dp[i][j] == 'Q') {
                return false;
            }
            i++;
            j--;
        }
        // right lower diagonal
        i = row + 1;
        j = col + 1;
        while (i < n && j < n) {
            if (dp[i][j] == 'Q') {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public void backtrack(char[][] dp,boolean [][] exis, int n, int queens) {
        if (queens > n) {
            return;
        } else if (queens == n) {
            addToList(dp, n);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (checkPosition(dp, n, i, j) && !exis[i][j]) {
                    dp[i][j] = 'Q';
                    // print(dp, n);
                    exis[i][j] = true;
                    backtrack(dp,exis, n, queens + 1);
                    exis[i][j] = false;
                    dp[i][j] = '.';
                }
            }
        }
    }

    public void print(char[][] dp, int n) {
        int i = 0, j = 0;
        System.out.print("\n[");
        for (i = 0; i < n; i++) {
            System.out.print("\"");
            for (j = 0; j < n; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.print("\",");
        }
        System.out.print("]");
    }

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<List<String>>();
        char[][] dp = new char[n][n];
        boolean [][] exis = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i],'.');
            Arrays.fill(exis[i], false);
        }
        backtrack(dp,exis, n, 0);
        return res;
    }

    public static void main(String[] args) {
        NQueens object = new NQueens();
        List<List<String>> list = object.solveNQueens(4);
        for (List<String> rows : list) {
            System.out.print("\n[");
            for (String row : rows) {
                System.out.print("\"" + row + "\",");
            }
            System.out.print("]");
        }
    }
}
package LeetCode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    List<List<String>> res;

    public void addToList(StringBuilder[] board, int n) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            list.add(board[i].toString());
        }
        if (!res.contains(list))
            res.add(list);
    }

    public void fillPoss(StringBuilder[] board, int n, int row, int col,char pLetter,char letter) {
        int i = 0, j = 0;
        
        // check row and column
        for (i = 0; i < n; i++) {
            if (board[i].charAt(col) == pLetter) {
                board[i].setCharAt(col,letter);
            }
            if (board[row].charAt(i) == pLetter) {
                board[row].setCharAt(i,letter);
            }
        }
        i = row - 1;
        j = col - 1;
        while (i >= 0 && j >=0 ) {
            if (board[i].charAt(j) == pLetter) {
                board[i].setCharAt(j, letter);
            }
            i--;
            j--;
        }
        i = row +1;
        j = col +1;
        while (i <n && j < n) {
            if (board[i].charAt(j) == pLetter) {
                board[i].setCharAt(j, letter);
            }
            i++;
            j++;
        }
        // right upper diagonal
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < n) {
            if (board[i].charAt(j) == pLetter ) {
                board[i].setCharAt(j, letter);
            }
            i--;
            j++;
        }
        i = row + 1;
        j = col - 1;
        while (i <n && j >=0) {
            if (board[i].charAt(j) == pLetter) {
                board[i].setCharAt(j, letter);
            }
            i++;
            j--;
        }
    }

    public void backtrack(StringBuilder[] board, int n, int queens) {
        if (queens > n) {
            return;
        } else if (queens == n) {
            addToList(board, n);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (board[i].indexOf("Q") != -1) {
                continue;
            }
            for (int j = 0; j < n; j++) {

                if (board[i].charAt(j) == '.') {
                    board[i].setCharAt(j, 'Q');
                    fillPoss(board,n,i,j,'.',(char)(queens+48));
                    // print(board,n);
                    backtrack(board, n, queens + 1);
                    fillPoss(board,n,i,j,(char)(queens+48),'.');
                    board[i].setCharAt(j, '.');
                }
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<List<String>>();
        StringBuilder[] board = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            board[i] = new StringBuilder(".".repeat(n));
        }
        backtrack(board, n, 0);
        return res;
    }



    //  public void print(StringBuilder[] board, int n) {
    //     int i = 0, j = 0;
    //     for (i = 0; i < n; i++) {
    //         System.out.print("___");
    //     }
    //     for (i = 0; i < n; i++) {
    //         System.out.print("\n| ");
    //         for (j = 0; j < n; j++) {
    //             System.out.print(board[i].charAt(j)+" ");
    //         }
    //         System.out.print(" |");
    //     }
    //     System.out.println();
    //     for (i = 0; i < n; i++) {
    //         System.out.print("___");
    //     }
    //     System.out.println();
    // }
    // public static void main(String[] args) {
    //     NQueens object = new NQueens();
    //     // List<List<String>> list = object.solveNQueens(3);
    //     // for (List<String> rows : list) {
    //     //     System.out.print("\n[");
    //     //     for (String row : rows) {
    //     //         System.out.print("\"" + row + "\",");
    //     //     }
    //     //     System.out.print("]");
    //     // }
    //     // String [] board = {"....","..Q.","....","...."};
    //     // StringBuilder [] sb = new StringBuilder[4];
    //     // for(int i = 0; i < 4; i++) {
    //     //     sb[i] = new StringBuilder(board[i]);
    //     // }
    //     // object.print(sb,4);
    //     // int row,col;
    //     // Scanner sc = new Scanner(System.in);
    //     // try{
    //     //     while(true){
    //     //         System.out.println("Enter row and column");
    //     //         row = sc.nextInt();
    //     //         col = sc.nextInt();
    //     //         System.out.println("Exist =>"+object.checkQueen(sb, 4, row, col));
    //     //     }
    //     // }finally{
    //     //     sc.close();
    //     // }
    // }
}
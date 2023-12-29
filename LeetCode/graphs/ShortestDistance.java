package LeetCode.graphs;

import java.util.Arrays;

public class ShortestDistance {
    int min_res;
    int[][] corner;
    public int shortestBridge(int[][] grid) {
        //identify 1st island
        int n = grid.length,row=-1,col=-1;
        min_res = Integer.MAX_VALUE;
        int[][] i_one = new int[n][n];
        boolean[][] vis = new boolean[n][n];
        for(int[] i: i_one) Arrays.fill(i,5000);
        for(int i=0;i<n && row == -1;++i){
            for(int j=0;j<n;++i){
                if(grid[i][j] == 1){
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        // get all four corners TOP BOTTOM LEFT RIGHT
        corner = new int[4][2];
        
        for(int[] i : corner){ // init corners
            i[0] = row;
            i[1] = col;
        }
        print(grid); // print
        dfs_fill(grid,i_one,row,col,n,vis); // fill the island 1
        for(int[] i : corner){ // init corners
            System.out.println("X: "+i[0]+" Y: "+i[1]);
        }
        // extend distance top left
        for(int i = corner[0][0],j = corner[0][1];i <= corner[2][0];++i){
            j = corner[0][1];
            while(j-1 >= 0 && grid[i][j-1] != 0) --j; // shift left
            System.out.println("TL: "+i+":"+j);
            dfs_extend(grid, i_one, 1, i-1, j, n, vis,true,true);
            dfs_extend(grid, i_one, 1, i, j-1, n, vis,true,true);
        }
        // extend distance bottom left
        for(int i = corner[2][0],j = corner[1][1];i <= corner[1][0];++i){ 
            j = corner[1][1];
            while(j-1 >= 0 && grid[i][j-1] != 0) --j; // shift left
            dfs_extend(grid, i_one, 1, i+1, j, n, vis,false,true);
            dfs_extend(grid, i_one, 1, i, j-1, n, vis,false,true);
        }
        // extend distance top right
        for(int i = corner[0][0],j = corner[0][1];i <= corner[3][0];++i){ 
            j = corner[0][1];
            while(j+1 < n && grid[i][j+1] != 0) ++j; // shift right
            dfs_extend(grid, i_one, 0, i-1, j, n, vis,true,false);
            dfs_extend(grid, i_one, 0, i, j+1, n, vis,true,false);
        }
        // extend distance bottom right
        for(int i = corner[3][0],j = corner[1][1];i <= corner[1][0];++i){ 
            j = corner[1][1];
            while(j+1 < n && grid[i][j+1] != 0) ++j; // shift right
            dfs_extend(grid, i_one, 0, i+1, j, n, vis,false,false);
            dfs_extend(grid, i_one, 0, i, j+1, n, vis,false,false);
        }
        System.out.println("ALL\n");
        print(i_one);
        return min_res;
    }
    public void dfs_extend(int[][] grid,int[][] i_one,int dist,int row,int col,int n,boolean[][] vis,boolean top,boolean left){
        if(row < 0 || row==n || col<0 || col==n || i_one[row][col] == 0 || vis[row][col]) return;// out of index
        
        if(grid[row][col] == 1 && i_one[row][col] != 0 && min_res >= dist){
            min_res = dist;
        }
        vis[row][col] = true;
        if(i_one[row][col] > dist){
            i_one[row][col] = dist;
        }
        if(top && left){
            
            dfs_extend(grid, i_one,dist+1, row-1, col, n, vis,top,left);
            dfs_extend(grid, i_one,dist+1, row, col-1, n, vis,top,left);
        }
        else if(!top && left){
            dfs_extend(grid, i_one,dist+1, row+1, col, n, vis,top,left);
            dfs_extend(grid, i_one,dist+1, row, col-1, n, vis,top,left);
        }
        else if(top && !left){
            dfs_extend(grid, i_one,dist+1, row-1, col, n, vis,top,left);
            dfs_extend(grid, i_one,dist+1, row, col+1, n, vis,top,left);
        }else{
            dfs_extend(grid, i_one,dist+1, row+1, col, n, vis,top,left);
            dfs_extend(grid, i_one,dist+1, row, col+1, n, vis,top,left);
        }
        vis[row][col] = false;
    }
    
    public void dfs_fill(int[][] grid,int[][] i_one,int row,int col,int n,boolean[][] vis){
        if(row < 0 || row==n || col<0 || col==n || grid[row][col] == 0 || vis[row][col]) return;
        i_one[row][col] = 0;
        vis[row][col] = true;
        if(corner[0][0] >= row){ //top
            corner[0][0] = row;
            corner[0][1] = col;
        }else if(corner[1][0] <= row){ //bottom
            corner[1][0] = row;
            corner[1][1] = col;
        }
        if(corner[2][1] >= col){ //left
            corner[2][0] = row;
            corner[2][1] = col;
        }else if(corner[3][1] <= col){ // right
            corner[3][0] = row;
            corner[3][1] = col;
        }
        dfs_fill(grid, i_one, row+1, col, n, vis);
        dfs_fill(grid, i_one, row-1, col, n, vis);
        dfs_fill(grid, i_one, row, col+1, n, vis);
        dfs_fill(grid, i_one, row, col-1, n, vis);
        vis[row][col] = false;
    }


    

    public void print(int[][] grid){
        System.out.println("\nGRID:\n");
        System.out.print(" ");
        for(int i=0;i<grid.length;++i){
            System.out.print("\t"+i);
        }
        System.out.println();
        for(int i=0;i<grid.length;++i){
            System.out.print("\n"+i);
            for(int j=0;j<grid.length;++j){
                if(grid[i][j] == -1){
                    System.out.print("\t"+grid[i][j]);    
                }else{
                    System.out.print("\t"+grid[i][j]);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] grid = new int[6][6];
        for(int i=0;i<3;++i) {
            grid[i][1] = 1;
            grid[i][2] = 1;
        }
        for(int i=0;i<4;++i) grid[1][i] = 1;
        grid[3][1] = 1;
        grid[3][5] = 1;
        ShortestDistance distance = new ShortestDistance();
        int res = distance.shortestBridge(grid);
        System.out.println("\nShortest Distance: "+distance.min_res);
    }
}

package LeetCode.graphs;

public class SnakeAndLadder {
    
}
class SolutionSnake {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean goRight = n%2 == 0;
        int pos = n*n;
        int[] cell = new int[pos+1];
        cell[pos] = 0;
        for(int i=0;i<n;++i){
            for(int j= goRight?0:n-1;j == -1 || j == n;j += goRight?1:-1){
                
            }
            goRight = !goRight;
        }
        goPrevious(0,goRight?0:n-1,pos,cell,board,goRight,n);
        return cell[1];
    }
    public void goPrevious(int i,int j,int pos,int[]cell,int[][]board,boolean goRight,int n){

    }
}

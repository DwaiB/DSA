class DistinctSequences {
    int [][] memo;
    int result,m,n;
    public int numDistinct(String s, String t) {
        n = s.length();
        m = t.length();
        result = 0;
        memo = new int[m+1][n+1];
        Arrays.fill(memo[0],0);
        for(int i=0;i<m+1;i++){
            memo[i][0] = 0;
        }
        char [] cs = s.toCharArray();
        char [] ct = t.toCharArray();
        int LCS = LCS(cs,ct);
        solve(cs,ct,m,n);
        int ans = DFS(cs,ct,0,0);
        System.out.println("DFS: "+ans);
        // printMemo();
        return result; 
    }
    
    public int LCS(char[] s, char[] t){

        for( int i = 1; i< m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(s[j-1] == t[i-1]){
                    memo[i][j] = 1 + memo[i-1][j-1];
                }else{
                    memo[i][j] = Math.max(memo[i][j-1],memo[i-1][j]);
                }
            }
        }
        return memo[m][n];
    }
    public void solve(char[] s, char[] t, int i, int j){
        if(i == 0){
            result++;
            return;
        }
        if(j == 0){
            return;
        }
        int k = j;
        while(k > 0){
            if(memo[i][k] < memo[i][j]){
                break;
            }
            if(s[k-1] == t[i-1]){
                solve(s,t,i-1,k-1);
            }
            k--;
        }
    }

    public int DFS(char[] s, char[] t, int i, int j){
        if( i == m){
            return 1;
        }
        if( j == n){
            return 0;
        }
        if(s[j] == t[i]){
            return DFS(s,t,i,j+1) + DFS(s,t,i+1,j+1);
        }else{
            return DFS(s,t,i,j+1);
        }
    }

    public void printMemo(){
        for(int i = 0;i < m+1; i++){
            for(int j = 0; j < n+1;j++){
                System.out.print(memo[i][j]+" ");
            }
            System.out.println();
        }
    }
}
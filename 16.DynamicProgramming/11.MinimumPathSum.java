//01.Recursion

class Solution {
    public int minPathSum(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;

        return helper(n-1,m-1,grid);
    }
    public int helper(int n , int m , int [][]grid){
        if(n==0 && m==0)return grid[n][m];
       
          int top=Integer.MAX_VALUE;
          int left=Integer.MAX_VALUE;

          if(n>0) top =helper(n-1 , m , grid);
          if(m>0) left = helper(n, m-1 , grid);

        return Math.min(top,left)+grid[n][m];
    }
}

//02.Memoization -Top/Down

class Solution {
    public int minPathSum(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
         int dp[][]= new int [n][m];
         for(int i=0;i<n;i++){
             Arrays.fill(dp[i],-1);
         }
        return helper(n-1,m-1,grid, dp);
    }
    public int helper(int n , int m , int [][]grid , int [][]dp){
        if(n==0 && m==0)return dp[n][m]=grid[n][m];
       
       if(dp[n][m]!=-1)return dp[n][m];
          int top=Integer.MAX_VALUE;
          int left=Integer.MAX_VALUE;
          
          if(n>0) top =helper(n-1 , m , grid,dp);
          if(m>0) left = helper(n, m-1 , grid,dp);

        return dp[n][m]=Math.min(top,left)+grid[n][m];
    }
}

//03.Tabulation - Bottom Up

class Solution {
    public int minPathSum(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
         int dp[][]= new int [n][m];
         for(int i=0;i<n;i++){
             Arrays.fill(dp[i],-1);
         }
         
         for(int i=0;i<n;i++){
             for(int j=0;j<m;j++){

                 if(i==0 && j==0) dp[i][j]=grid[0][0];
                 else {
                     int top=Integer.MAX_VALUE;
                     int left=Integer.MAX_VALUE;

                     if(i>0)top=dp[i-1][j];
                     if(j>0)left=dp[i][j-1];

                     dp[i][j]=grid[i][j]+Math.min(top,left);
                 }
             }
         }
         return dp[n-1][m-1];
    }
}

04.Space Optimization 

  class Solution {
    public int minPathSum(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
         int dp[]= new int [m];
   
         for(int i=0;i<n;i++){
             int temp[]=new int [m];
             for(int j=0;j<m;j++){

                 if(i==0 && j==0) temp[j]=grid[0][0];
                 else {
                     int top=Integer.MAX_VALUE;
                     int left=Integer.MAX_VALUE;

                     if(i>0)top=dp[j];
                     if(j>0)left=temp[j-1];

                     temp[j]=grid[i][j]+Math.min(top,left);
                 }
             }
             dp=temp;
         }
         return dp[m-1];
    }
}

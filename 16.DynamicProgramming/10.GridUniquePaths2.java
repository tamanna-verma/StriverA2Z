//01.Recursion
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        return helper(n-1 , m-1 , obstacleGrid);

    }
    public int helper(int n ,int m , int[][] grid){
         if(n>=0 && m>=0 && grid[n][m]==1)return 0;
        if(n==0 && m==0)return 1;
        if(n<0 || m<0)return 0;
       

        int top=helper(n-1, m , grid);
        int left = helper(n, m-1, grid);
        return top+left; 
    }
}
//02.Memoization - Top Down

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int dp[][]=new int [n][m];
        for(int i=0;i<dp.length;i++)Arrays.fill(dp[i],-1);
        return helper(n-1 , m-1 , obstacleGrid, dp);

    }
    public int helper(int n ,int m , int[][] grid, int [][]dp){
         if(n>=0 && m>=0 && grid[n][m]==1)return 0;
        if(n==0 && m==0)return 1;
        if(n<0 || m<0)return 0;
        if(dp[n][m]!=-1)return dp[n][m];
        int top=helper(n-1, m , grid,dp);
        int left = helper(n, m-1, grid,dp);
        return dp[n][m]=top+left; 
    }
}

03.Tabulation 

  //recursion
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int dp[][]=new int [n][m];
        for(int i=0;i<dp.length;i++)Arrays.fill(dp[i],-1);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0 && obstacleGrid[i][j]==0)dp[i][j]=1;
                else if(obstacleGrid[i][j]==1)dp[i][j]=0;
                else{
                int top=0;
                int left=0;
                if(i>0)top=dp[i-1][j];
                if(j>0)left=dp[i][j-1];

                dp[i][j]=top+left;
                }
            }
           
        }
         return dp[n-1][m-1];
    }
}

//04.Space Optimisation

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int dp[]=new int[m];
       // for(int i=0;i<dp.length;i++)Arrays.fill(dp[i],-1);
       
        for(int i=0;i<n;i++){
            int temp[]=new int [m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0 && obstacleGrid[i][j]==0)temp[0]=1;
                else if(obstacleGrid[i][j]==1)temp[j]=0;
                else{
                int top=0;
                int left=0;
                if(i>0)top=dp[j];
                if(j>0)left=temp[j-1];

               temp[j]=top+left;
                }
            }
            dp=temp;
           
        }
         return dp[m-1];
    }
}

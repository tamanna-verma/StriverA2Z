01.Recursion 

  class Solution {
    public int uniquePaths(int m, int n)
    {
       return helper(m-1,n-1);
    }
    public int helper(int m , int n){
        if(m==0 && n==0)return 1;
        if(m<0 || n<0)return 0;

       int up = helper(m-1,n);
       int left=helper(m,n-1);

       return up+left; 
    }
}

02.Memoization - Top Down 

  class Solution {
    public int uniquePaths(int m, int n)
    {
       int [][]dp = new int [m][n];
       for(int i=0;i<dp.length;i++){
           Arrays.fill(dp[i],-1);
       }
       return helper(m-1,n-1 , dp);
    }
    public int helper(int m , int n , int [][]dp){
        if(m==0 && n==0)return 1;
        if(m<0 || n<0)return 0;
      
      if(dp[m][n]!=-1)return dp[m][n];
       int up = helper(m-1,n,dp);
       int left=helper(m,n-1,dp);

       return dp[m][n]=up+left; 
    }
}

03.Tabulation - Bottom Up
  class Solution {
    public int uniquePaths(int m, int n)
    {
       int [][]dp = new int [m][n];
       dp[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int left=0;
                int up=0;
                if(i-1>=0)
                {
                    up=dp[i-1][j];
                 }
                 if(j-1>=0){
                     left=dp[i][j-1];
                 }
             if(!(i==0 && j==0))dp[i][j]= up+left;
            }
        }
        return dp[m-1][n-1];
    }
}

04.Space Optimization 
  class Solution {
    public int uniquePaths(int m, int n)
    {
       int []dp = new int [n];
        for(int i=0;i<m;i++)
        {
            int temp[]=new int [n];
            for(int j=0;j<n;j++)
            {
               if(i==0 &&j==0)temp[j]=1;
               else{
                int left=0;
                int up=0;
                if(i>0)up=dp[j];
                if(j>0)left=temp[j-1]; 
                temp[j]= up+left;
               }
            }
            dp=temp;
        }
        return dp[n-1];
    }
}

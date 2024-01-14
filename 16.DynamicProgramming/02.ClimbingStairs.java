// 1.Recursion - gives TLE

class Solution {
    public int climbStairs(int n)
    {
        if(n==1 || n==2)return n ;
        return climbStairs(n-1) + climbStairs(n-2);
        
    }
}

//2.Memoization - Top Down 

class Solution {
    public int climbStairs(int n)
    {
      int dp []= new int [n+1];
      int ans= helper(n , dp); 
      return ans; 
    }
    public int helper(int n , int []dp){
        if(n==1 || n==2){
            dp[n]=n;
            return n ;
        }

        return dp[n] = helper(n-1 , dp)+helper(n-2,dp);
    }
}

//3.Tabulation - Bottom Up 

class Solution {
    public int climbStairs(int n)
    {
        if(n<=2)return n;
      int dp []= new int [n+1];
       helper(dp); 
      return dp[n]; 
    }
    public void helper( int []dp){
      
        dp[1]=1;
        dp[2]=2;

        for(int i=3;i<dp.length;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
    }
}

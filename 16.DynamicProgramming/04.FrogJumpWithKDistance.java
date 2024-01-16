


//using recursion
//represent the problem in terms of index 
//do all possible stuff on that index 
// count all ways = sum all the stuff
// find min / max = min / max of all stuff









02.Memoization - Top Down
import java.util.Arrays;
public class Solution {
    public static int minimizeCost(int n, int k, int []height){
        // using recursion 
        int dp[] = new int [n];
        Arrays.fill(dp,-1);
      return helper(n-1,k,height,dp);

    }
    public static int helper(int n , int k , int height[], int dp[]){
          if(n==0)return 0;
          if(dp[n]!=-1)return dp[n];
         int ans =Integer.MAX_VALUE;
         for(int i=1;i<=k;i++){
             if(n-i>=0)
             {
             int curr = Math.abs(height[n]-height[n-i]) + helper(n-i , k , height,dp);
             ans=Math.min(ans,curr);
             }
            
         }
         return dp[n]= ans;
    }
}


03.Tabulation - Bottom Up 
  //tabulation
public class Solution {
    public static int minimizeCost(int n, int k, int []height){
        int []dp = new int [n];
        dp[0]=0;
        for(int i=1;i<n;i++)
        {
           int curr = Integer.MAX_VALUE;
           for(int j=1;j<=k;j++)
           {
               if(i-j>=0)
               curr = Math.min(curr , Math.abs(height[i]-height[i-j]) + dp[i-j]);
           }
            dp[i]=curr;
        }
        return dp[n-1];

    }
}


//04 . We can space optimize it , using a dp array of only size k 
// on each coming index , we only keep last k values of the dp array , rest we avoid 

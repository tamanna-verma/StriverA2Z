01.Using Recursion

import java.util.Arrays;
public class Solution 
{
    public static int frogJump(int n, int heights[]) {
        int totalEnergy = helper(n-1 , heights);
        return totalEnergy;
        
    }
    public static int helper(int n , int heights[]){
           if(n==0)return 0;
          
          int left = Math.abs(heights[n]-heights[n-1])+ helper(n-1, heights);
          int right = Integer.MAX_VALUE;
          if(n>1)
          {
           right = Math.abs(heights[n]-heights[n-2])+ helper(n-2, heights);
          }
         int energytilln =  Math.min(left, right);
         
          return energytilln;
   
    }

}

02.Using Memoization - Top down and memorise the states


import java.util.Arrays;
public class Solution 
{
    public static int frogJump(int n, int heights[]) {
      int dp []=new int [n];
      Arrays.fill(dp,-1);
      dp[0]=0;
        int totalEnergy = helper(n-1 , heights , dp);
        return totalEnergy;
        
    }
    public static int helper(int n , int heights[] , int dp[]){
           if(n==0)return 0;
          
          if(dp[n]!=-1)return dp[n];
          int left = Math.abs(heights[n]-heights[n-1])+ helper(n-1, heights , dp);
          int right = Integer.MAX_VALUE;
          if(n>1)
          {
           right = Math.abs(heights[n]-heights[n-2])+ helper(n-2, heights , dp);
          }
         int energytilln =  Math.min(left, right);
         
         dp[n]=energytilln;
         return energytilln;
   
    }

}

03.Using tabulation - bottom up
import java.util.Arrays;
public class Solution 
{
    public static int frogJump(int n, int heights[]) {
    int[]dp=new int[n];
      dp[0]=0;
      dp[1]= Math.abs(heights[1]-heights[0]);
     for(int i=2;i<n;i++){
        
        dp[i] = Math.min(dp[i-1]+(Math.abs(heights[i]-heights[i-1])),dp[i-2]+(Math.abs(heights[i]-heights[i-2])));
     }
     return dp[n-1];
        
    }
   

}

04.Best Way - Space Optimizeed to O(1)
    
import java.util.Arrays;
public class Solution 
{
    public static int frogJump(int n, int heights[]) {
    int[]dp=new int[n];
     
      int secondprev =0;
      int prev = Math.abs(heights[1]-heights[0]);
     for(int i=2;i<n;i++){
        
        dp[i] = Math.min(prev+(Math.abs(heights[i]-heights[i-1])),secondprev+(Math.abs(heights[i]-heights[i-2])));
        secondprev=prev;
        prev=dp[i];
     }
     return prev;
        
    }
   

}

01.Recursion 

  public class Solution {
    public static int minSubsetSumDifference(int []nums, int n) {
      
        int total = 0;
        for(int i=0;i<nums.length;i++){
          if(nums[i]>0)  total+=nums[i];
        }

        boolean []targetsPossible=new boolean[total+1];
        for(int i=0;i<total+1;i++){
            targetsPossible[i] = subsetSumEqualToTarget(n-1,i,nums);
        }

        int ans=Integer.MAX_VALUE;
        for(int i=0;i<total+1;i++){
            if(targetsPossible[i]==true && targetsPossible[total-i]==true)
            ans=Math.min(ans, Math.abs((total-i)-i));
        }
        return ans;
    }
    public static boolean subsetSumEqualToTarget(int index , int target , int []nums){
        if(index==0 && target == nums[0])return true;
        if(target==0)return true;
        if(index<0)return false;

        boolean pick=false;
        if(nums[index]<=target)pick= subsetSumEqualToTarget(index-1 , target-nums[index], nums);
        boolean notpick = subsetSumEqualToTarget(index-1 , target , nums);

        return pick||notpick;
    }
}


02.MEMOIZATION - TOP DOWN 

import java.util.*;
public class Solution {
    public static int minSubsetSumDifference(int []nums, int n) {
      
        int total = 0;
        for(int i=0;i<nums.length;i++)
        {
          total+=nums[i];
        }

        int [][]dp = new int [n][total+1];
        for(int i=0;i<n;i++)
        {
          Arrays.fill(dp[i],-1);
        }  
        
        for(int i=0;i<total+1;i++){
           boolean temp= subsetSumEqualToTarget(n-1,i,nums, dp);
        }     
 
       

        int ans=Integer.MAX_VALUE;
        for(int i=0;i<total+1;i++){
            if(dp[n-1][i]==1 && dp[n-1][total-i]==1)
            ans=Math.min(ans, Math.abs((total-i)-i));
        }
        return ans;
    }
    public static boolean subsetSumEqualToTarget(int index , int target , int []nums , int dp[][]){
        if((index==0 && target == nums[0]) || target==0)
        {
            dp[index][target]=1;
            return  true;
        }  
        if(index<0 )
        {
         
         return false;
        }
         if(dp[index][target]!=-1)return dp[index][target]==1?true:false;

        boolean pick=false;
        if(nums[index]<=target)pick= subsetSumEqualToTarget(index-1 , target-nums[index], nums,dp);
        boolean notpick = subsetSumEqualToTarget(index-1 , target , nums,dp);

        if(pick|| notpick){
            dp[index][target]=1;
        }
        else dp[index][target]=0;
        return pick||notpick;
    }
}


03.TABULATION - BOTTOM UP 

import java.util.*;
public class Solution {
    public static int minSubsetSumDifference(int []nums, int n) {
      
        int total = 0;
        for(int i=0;i<nums.length;i++)
        {
          total+=nums[i];
        }

        int [][]dp = new int [n][total+1];
        
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        dp[0][nums[0]]=1;

        for(int i=1;i<n;i++){
            for(int j=0;j<total+1;j++){
               
               int pick = 0;
               if(nums[i]<=j)pick = dp[i-1][j-nums[i]];
               int notpick = dp[i-1][j];

               if(pick==1||notpick==1)dp[i][j]=1;
               else dp[i][j]=0;
                
            }
        } 

        int ans=Integer.MAX_VALUE;
        for(int i=0;i<total+1;i++){
            if(dp[n-1][i]==1 && dp[n-1][total-i]==1)
            ans=Math.min(ans, Math.abs((total-i)-i));
        }
        return ans;
    }
    
}


04.SPACE OPTIMIZATION 

  import java.util.*;
public class Solution {
    public static int minSubsetSumDifference(int []nums, int n) {
      
        int total = 0;
        for(int i=0;i<nums.length;i++)total+=nums[i];
        
        int []dp=new int [total+1];
        dp[0]=1;
        dp[nums[0]]=1;
        for(int i=1;i<n;i++){
            int temp[]= new int [total+1];
            for(int j=0;j<total+1;j++){    
               int pick = 0;
               if(nums[i]<=j)pick = dp[j-nums[i]];
               int notpick = dp[j];

               if(pick==1||notpick==1)temp[j]=1;
               else temp[j]=0;
                
            }
            dp=temp;
        } 

        int ans=Integer.MAX_VALUE;
        for(int i=0;i<total+1;i++){
            if(dp[i]==1 && dp[total-i]==1)
            ans=Math.min(ans, Math.abs((total-i)-i));
        }
        return ans;
    }
    
}


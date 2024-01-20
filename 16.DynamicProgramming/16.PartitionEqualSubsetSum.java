01.Recursion 

  class Solution {
    public boolean canPartition(int[] nums)
    {
      // partition tab hai hoskta hai if the total sum is even 
      int total=0;
      int n=nums.length;
      for(int i=0;i<nums.length;i++)total+=nums[i];
      if(total%2==1)return false;
      int target = total/2;
      //now we need to find subset sum equal to target
      boolean ans= helper(n-1 , target ,nums);
      return ans;
    }
    public boolean helper(int index , int target , int [] nums){
        if(index==0 && target==nums[0])return true;
        if(target==0)return true;
        if(index<0)return false;

        boolean pick = helper(index-1 , target-nums[index] ,  nums);
        boolean notpick = helper(index-1 , target , nums);
        return pick||notpick;
    }
}

02.MEMOIZATION - Top Down 

  class Solution {
    public boolean canPartition(int[] nums)
    {
      // partition tab hai hoskta hai if the total sum is even 
      int total=0;
      int n=nums.length;
      for(int i=0;i<nums.length;i++)total+=nums[i];
      if(total%2==1)return false;
      int target = total/2;
      //now we need to find subset sum equal to target
      int [][]dp= new int [n][target+1];
      for(int i=0;i<n;i++){
          Arrays.fill(dp[i] , -1);
      }
      boolean ans= helper(n-1 , target ,nums , dp);
      return ans;
    }
    public boolean helper(int index , int target , int [] nums , int [][]dp){
        if((index==0 && target==nums[0]) || (target==0))
        {
          dp[index][target]=1;
          return true;
        }
        if(index<0)return false;

        if(dp[index][target]!=-1)return dp[index][target]==1?true:false;
        boolean pick=false;
        if( nums[index]<=target) pick = helper(index-1 , target-nums[index] ,  nums, dp);
        boolean notpick = helper(index-1 , target , nums , dp);
        if(pick || notpick){
            dp[index][target]=1;
        }else dp[index][target]=0;

        return pick || notpick;
    }
}

03.TABULATION - Bottom Up
  
class Solution {
    public boolean canPartition(int[] nums)
    {
      // partition tab hai hoskta hai if the total sum is even 
      int total=0;
      int n=nums.length;
      for(int i=0;i<nums.length;i++)total+=nums[i];
      if(total%2==1)return false;
      int target = total/2;
      //now we need to find subset sum equal to target
      int [][]dp= new int [n][target+1];
      for(int i=0;i<n;i++){
          dp[i][0]=1;
      }
    if(nums[0]<target)  dp[0][nums[0]]=1;

      for(int i=1;i<n;i++){
          for(int j=0;j<target+1;j++){

              boolean pick =false;
             if(nums[i]<=j)  pick= dp[i-1][j-nums[i]]==1?true:false;
             boolean notpick = dp[i-1][j]==1?true:false;

             dp[i][j]=pick||notpick?1:0;
          }
      }
    
      return dp[n-1][target]==1?true:false;
    }
  
}

04.SPACE OPTIMIZATION 

  class Solution {
    public boolean canPartition(int[] nums)
    {
      // partition tab hai hoskta hai if the total sum is even 
      int total=0;
      int n=nums.length;
      for(int i=0;i<nums.length;i++)total+=nums[i];
      if(total%2==1)return false;
      int target = total/2;
      //now we need to find subset sum equal to target
      int []dp= new int [target+1];
    
     if(nums[0]<=target) dp[nums[0]]=1;

      for(int i=1;i<n;i++){
          int temp[]=new int [target+1];
          for(int j=0;j<target+1;j++){

              boolean pick =false;
             if(nums[i]<=j)  pick= dp[j-nums[i]]==1?true:false;
             boolean notpick = dp[j]==1?true:false;

             temp[j]=pick||notpick?1:0;
          }
          dp=temp;
      }
    
      return dp[target]==1?true:false;
    }
  
}

01.RECURSION 

          // divide them into 2 subsets where partition difference is target 
        //and sum of partitions can be 0 to total;
        // 1-3+2-3+4=1;

        // 4+2+1 -3-3 = 1
        // 7 -6 = 1
        // sum1 -sum2 is a target which is possible and 1 is the difference
// s1-s2=d
        
// s1+s2=total//subtract 1 from other
// s1=total-d/2
// no.of ways to have s1=no.of ways to have diff
  class Solution 
  {
    public int findTargetSumWays(int[] nums, int diff)
    {
      int n=nums.length;
      int total=0;
      for(int i=0;i<n ;i++){
          total+=nums[i];
      }
      int []targetsum=new int [total+1]; 
     if(total-diff<0 || (total-diff)%2!=0 )return 0;
     int ans=helper(n-1 , nums , (total-diff)/2);
    return ans;
   }
    public int helper(int index , int nums[] , int target){
 
       if(index<0 && target==0 )return 1;
        else if(index<0 ) return 0;
        int take =0;
        if(target>=nums[index]) take = helper(index-1 , nums , target-nums[index]);
        int nottake = helper(index-1 , nums , target);
        return take+nottake;
  
    }

}
02.MEMOIZATION - TOP DOWN 

  class Solution {
    public int findTargetSumWays(int[] nums, int diff)
    {
  int n=nums.length;
      int total=0;
      for(int i=0;i<n ;i++){
          total+=nums[i];
      }
    int []targetsum=new int [total+1]; 
    if(total-diff<0 || (total-diff)%2!=0 )return 0;
    int target= (total-diff)/2;
    int dp[][]=new int[n][target+1];
    for(int i=0;i<n;i++){
        Arrays.fill(dp[i],-1);
    }
    int ans=helper(n-1 , nums , (total-diff)/2 , dp);
    return ans;
      
    }
    public int helper(int index , int nums[] , int target, int [][]dp){
       if(index<0 && target==0 )return 1;
        else if(index<0 ) return 0;
        if(dp[index][target]!=-1)return dp[index][target];
        int take =0;
        if(target>=nums[index]) take = helper(index-1 , nums , target-nums[index],dp);
        int nottake = helper(index-1 , nums , target,dp);
        return dp[index][target]=take+nottake;
     
    }

}


03.TABULATION 
  class Solution {
    public int findTargetSumWays(int[] nums, int diff)
    { 
        // (a1+a2+a3) - (b1+b2+b3) = d
        // s1+s2=total;
        // s1-s2=d
        // 2s2=total-d;
        // s2=total-d/2
        // if(total<d)return 0;
        // if((total-d )% 2 !=0)return 0;

       int n=nums.length;
       int total =0;
       for(int i=0;i<n;i++){
           total+=nums[i];
       }
       if(total<diff || (total-diff)%2!=0)return 0;
       int s1= (total-diff)/2;
      // now the number of ways where s1 is the target is the answer 
      int dp[][]=new int[n][s1+1];
     dp[0][0]=1;
     if(nums[0]==0)   dp[0][nums[0]]=2;
     else if(nums[0]<=s1)dp[0][nums[0]]=1;
   

        for(int i=1;i<n;i++){
         for(int j=0;j<s1+1;j++){
         
             int take=0;
             if(nums[i]<=j)take=dp[i-1][j-nums[i]];
              int nottake=dp[i-1][j];

              dp[i][j]=take+nottake;
             

         }
        }
      return dp[n-1][s1];

    }
}

//  0456




//01.RECURSION

//doing it using recursion
class Solution 
{
    public int rob(int[] nums)
    {
       int ans = helper(nums.length-1, nums);
       return ans;

    }
    public int helper(int n , int nums[]){
      if(n==0)return nums[0];
      
       int left =nums[n];
       int right =Integer.MIN_VALUE;
       if(n-2>=0)
       {
       left = helper(n-2, nums)+nums[n];
       }
       right = helper(n-1, nums);

      return Math.max(left, right);
    }
}

//02.MEMOIZATION - TOP DOWN

class Solution 
{
    public int rob(int[] nums)
    {
        int dp []=new int [nums.length];
        Arrays.fill(dp,-1);
       int ans = helper(nums.length-1, nums, dp);
       return ans;

    }
    public int helper(int n , int nums[] , int []dp){
      if(n==0)return nums[0];
      
      if(dp[n]!=-1)return dp[n];
       int left =nums[n];
       int right =Integer.MIN_VALUE;
       if(n-2>=0)
       {
       left = helper(n-2, nums,dp)+nums[n];
       }
       right = helper(n-1, nums , dp);

      return dp[n]=Math.max(left, right);
    }
}

03.TABULATION - BOTTOM UP

  //doing it using recursion
class Solution 
{
    public int rob(int[] nums)
    {
        int dp []=new int [nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            
            int left = nums[i];
            if(i-2>=0)left += dp[i-2];
            int right= dp[i-1];

            dp[i]=Math.max(left,right);
        }
        return dp[nums.length-1];
    }
}

04.Best Approach - Optimised Space 

  
class Solution 
{
    public int rob(int[] nums)
    { 
        if(nums.length==1)return nums[0];
        if(nums.length==2)return Math.max(nums[0],nums[1]);

        int secondprev=nums[0];
        int prev=Math.max(nums[0],nums[1]);

        
        for(int i=2;i<nums.length;i++){
            
            int left = nums[i]+ secondprev;
            int right= prev;

            secondprev=prev;
            prev=Math.max(left,right);
        }
        return prev;
    }
}

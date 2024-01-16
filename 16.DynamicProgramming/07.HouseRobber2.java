01.Recursion
  class Solution {
    public int rob(int[] nums) 
    {
        if(nums.length==1)return nums[0];
       int firstarray []= new int [nums.length-1];
       for(int i=0;i<firstarray.length;i++){
           firstarray[i]=nums[i];
       }
       int ans1 = helper(firstarray , nums.length-2);
       
         for(int i=0;i<firstarray.length;i++){
           firstarray[i]=nums[i+1];
       }
        int ans2 = helper(firstarray , nums.length-2);

        return Math.max(ans1,ans2);
    }
    public int helper(int [] nums , int n ){
     if(n==0)return nums[0];
     if(n<0)return 0;

     int left = nums[n] + helper(nums,n-2);
      int right= helper(nums, n-1);

       return Math.max(left,right);
    }
}

02.MEMOIZATION - TOP DOWN 

  class Solution {
    public int rob(int[] nums) 
    {
        int n=nums.length;
        if(n==1)return nums[0];
        int dp[]=new int [n-1];
        Arrays.fill(dp,-1);
       int firstarray []= new int [n-1];
       for(int i=0;i<n-1;i++){
           firstarray[i]=nums[i];
       }
       int ans1 = helper(firstarray , n-2 , dp);
       
       Arrays.fill(dp,-1);
         for(int i=0;i<firstarray.length;i++){
           firstarray[i]=nums[i+1];
       }
        int ans2 = helper(firstarray , n-2 , dp);

        return Math.max(ans1,ans2);
    }
    public int helper(int [] nums , int n , int dp [] ){
     if(n==0)return nums[0];
     if(n<0)return 0;
     if(dp[n]!=-1)return dp[n];
     int left = nums[n] + helper(nums,n-2, dp);
      int right= helper(nums, n-1, dp);

       return dp[n]=Math.max(left,right);
    }
}

03.TABULATION - BOTTOM UP

  class Solution {
    public int rob(int[] nums) 
    {
        int n=nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);
        int dp[]=new int [n-1];
        Arrays.fill(dp,-1);
       int firstarray []= new int [n-1];
       for(int i=0;i<n-1;i++){
           firstarray[i]=nums[i];
       }
       int ans1 = helper(firstarray , n-2 , dp);
       
       Arrays.fill(dp,-1);
         for(int i=0;i<firstarray.length;i++){
           firstarray[i]=nums[i+1];
       }
        int ans2 = helper(firstarray , n-2 , dp);

        return Math.max(ans1,ans2);
    }
    public int helper(int [] nums , int n , int dp [] ){
     dp[0]=nums[0];
     dp[1]=Math.max(nums[0],nums[1]);
      
      for(int i=2;i<=n;i++){
       int left = dp[i-2]+nums[i];
       int right = dp[i-1];
       dp[i]=Math.max(left, right);
      }
      return dp[n];
    }
}


04.BEST APPROACH - OPTIMIZED SPACE 

  class Solution {
    public int rob(int[] nums) 
    {
        int n=nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);
        int dp[]=new int [n-1];
        Arrays.fill(dp,-1);
       int firstarray []= new int [n-1];
       for(int i=0;i<n-1;i++){
           firstarray[i]=nums[i];
       }
       int ans1 = helper(firstarray , n-2 , dp);
       
       Arrays.fill(dp,-1);
         for(int i=0;i<firstarray.length;i++){
           firstarray[i]=nums[i+1];
       }
        int ans2 = helper(firstarray , n-2 , dp);

        return Math.max(ans1,ans2);
    }
    public int helper(int [] nums , int n , int dp [] ){
     int secondprev=nums[0];
     int prev=Math.max(nums[0],nums[1]);
      
      for(int i=2;i<=n;i++){
       int left = secondprev+nums[i];
       int right =prev;

       dp[i]=Math.max(left, right);
       secondprev=prev;
       prev=dp[i];
      }
      return prev;
    }
}

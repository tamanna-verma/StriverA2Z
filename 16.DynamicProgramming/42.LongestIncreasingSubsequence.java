//01. RECURSION
class Solution 
{
    public int lengthOfLIS(int[] nums)
   {
        int prev = -1;
        int ans = helper(prev , 0, nums);
        return ans ;
        
    }
    public static int helper(int prev , int index , int nums[]){
        if (index>=nums.length)return 0;  
        int take = 0;    
        if(prev == -1 || nums[prev]< nums[index])take = 1 + helper(index , index+1 , nums);//to include this element 
        int nottake = helper(prev , index+1 , nums);// to not include this element 
        return Math.max(take , nottake);

    }
}

 // we need to keep a track of previously taken index 
 //we cant do it using brute force  , so we will be doing it using recursion 
 //we will be taking the current element into consideration , we will change curr to next and prev to current and do the recursion 
 //if not , we will change curr to next 
 // memoization -  top down - top to base case 

//02.MEMOIZATION

class Solution 
{
    public int lengthOfLIS(int[] nums)
    {
        int n = nums.length;
        int dp [][] = new int [n+1][n];
        for(int i=0;i<n ;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        
        int ans = helper(-1, 0, nums , dp);
        return ans ;
        
    }
    public static int helper(int prev , int index , int nums[] , int dp [][]){
        if (index>=nums.length)return 0;
        if( dp [prev+1][index] != -1 )return dp[prev+1][index]; 
        int take = 0;    
        if(prev ==-1 || nums[prev] < nums[index]) take = 1+  helper(index , index+1 , nums,dp);//to include this element 
        int nottake = helper(prev , index+1 , nums,dp);// to not include this element 
        return dp[prev+1][index]= Math.max(take , nottake);

    }
}

01. Recursion

import java.util.* ;
import java.io.*; 

public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int n = nums.size();
		return helper(n-1 , nums);
	}
	public static int helper(int n , ArrayList<Integer> nums){
         if(n==0)return nums.get(0);
		 if(n<0)return 0;

		 int pick = nums.get(n)+helper(n-2, nums);
		 int nonpick = helper(n-1, nums);

		 return Math.max(pick , nonpick);
	}
}

02.Memoization - Top Down 

import java.util.* ;
import java.io.*; 

public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int n = nums.size();
		int dp []= new int [n];
		Arrays.fill(dp,-1);
		return helper(n-1 , nums , dp);
	}
	public static int helper(int n , ArrayList<Integer> nums , int dp []){
         if(n==0)return dp[0]=nums.get(0);
		 if(n<0)return 0;
          
		  if(dp[n]!=-1)return dp[n];
		 int pick = nums.get(n)+helper(n-2, nums , dp);
		 int nonpick = helper(n-1, nums,dp);

		 return dp[n] = Math.max(pick , nonpick);
	}
}

03. Tabulation - Bottom Up 
  
import java.util.* ;
import java.io.*; 

public class Solution
{
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums)
	{
	int n = nums.size();
	int dp[] = new int[n];
	dp[0]=nums.get(0);

	
	for(int i=1;i<n;i++)
	{
	int left  = Integer.MIN_VALUE;
	int right = Integer.MIN_VALUE;
		if(i-2>=0)
		{
		 left = dp[i-2]+nums.get(i);
		}
		else left =nums.get(i);
		
		 right = dp[i-1];	

		dp[i]=Math.max(left, right);
	}

	return dp[n-1];
	}
}

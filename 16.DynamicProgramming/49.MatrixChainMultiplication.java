01.RECURSION
  
import java.util.*;
public class Solution {

	
	public static int mcm(int[] p){
	

    int n = p.length;
	int ans = helper(1 ,n-1, p);
	return ans;
	}

	public static int helper(int start , int end , int p[] ){
	 
      if(start>=end)return 0;
     
      int max= Integer.MAX_VALUE;
	  for(int i=start;i<end;i++)
	  {
		int left = helper(start,i,p);
		int right = helper(i+1,end,p);
		int ans= left + right + (p[start-1] * p[i] * p[end]);
		max= Math.min(max , ans);
	}
     return max;
	}
	
}







02.MEMOIZATION 

import java.util.*;
public class Solution {

	
	public static int mcm(int[] p){
		
	//	we need to return the matrix chain multiplication max
	// we need from which index till which index the answer 
	// index 1 to index n-1
	// index 0 , index 1 are the dimensions of the array 
	
	// i is the start point , j is the end point , k is the common direction

    int n = p.length;
	int dp[][]= new int [n][n];
	for(int i=0;i<n;i++){
		Arrays.fill(dp[i],-1);
		}
	int ans = helper(1 ,n-1, p, dp);
	return ans;
	}

	public static int helper(int start , int end , int p[], int dp[][] ){
	 
      if(start>=end)return 0;
      if(dp[start][end]!=-1)return dp[start][end];

      int max= Integer.MAX_VALUE;
	  for(int i=start;i<end;i++) //I WILL BE TILL N-2 SO THAT WE CAN GET N-1 TO END I.E N-1
	  {
		int left = helper(start,i,p,dp);
		int right = helper(i+1,end,p,dp);
		int ans= left + right + (p[start-1] * p[i] * p[end]);
		max= Math.min(max , ans);
	}
     return dp[start][end] =max;
	}
	
}

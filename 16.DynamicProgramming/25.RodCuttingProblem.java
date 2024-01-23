01.RECURSION 
  public class Solution {
	public static int cutRod(int price[], int n){
		int size=n;
		int length[]=new int [n];
		for(int i=0;i<n;i++)length[i]=i+1;
		int ans = helper(n-1 ,length , price,size);
		return ans;

	}
	public static int helper( int index , int[] length , int []price, int size){
		if(index==0){
			return (size/length[index])*price[index];
		}

		int take= 0;
		if(size>=length[index])take+=price[index] + helper(index, length , price , size-length[index]);
		int nottake = helper(index-1, length , price , size);

	   return Math.max(take , nottake);
	}
}

02.MEMOIZATION - TOP DOWN

  import java.util.*;
public class Solution {
	public static int cutRod(int price[], int n){
        int dp[][]= new int [n][n+1];
		for(int i=0;i<n;i++){
		  Arrays.fill(dp[i],-1);
		}
		int ans = helper(n-1 ,price, n ,dp);
		return ans;

	}
	public static int helper( int index ,int []price, int size, int dp[][]){
		if(index==0){
			return (size/(index+1))*price[index];
		}
        if( dp[index][size]!=-1)return dp[index][size];
		int take= 0;
		if(size>=index+1)take+=price[index] + helper(index,price,size-(index+1),dp);
		int nottake = helper(index-1,price , size,dp);

	   return dp[index][size]=Math.max(take , nottake);
	}
}

3.TABULATION - BOTTOM UP

  import java.util.*;
public class Solution {
	public static int cutRod(int price[], int n){
        int dp[][]= new int [n][n+1];
		
		for(int i=0;i<n+1;i++){
			dp[0][i]=i*price[0];
		}
		
		for(int i=1;i<n;i++){
			for(int j=0;j<n+1;j++){
				int take = Integer.MIN_VALUE;
				if(i+1<=j)take = price[i] + dp[i][j-(i+1)];
				int nottake= dp[i-1][j];

				dp[i][j]=Math.max(take,nottake);
			}
		}
        

	   return dp[n-1][n];
	}
}

04.SPACE OPTIMIZATION - 2 ARRAYS 

import java.util.*;
public class Solution {
	public static int cutRod(int price[], int n){
        int dp[]= new int[n+1];
		
		for(int i=0;i<n+1;i++){
			dp[i]=i*price[0];
		}
		
		for(int i=1;i<n;i++){
			   int temp[]= new int[n+1];
			for(int j=0;j<n+1;j++){
				int take = Integer.MIN_VALUE;
				if(i+1<=j)take = price[i] + temp[j-(i+1)];
				int nottake= dp[j];

				temp[j]=Math.max(take,nottake);
			}
			dp=temp;
		}
        

	   return dp[n];
	}
}

05. SPACE OPTIMIZATION - 1 ARRAY 
    import java.util.*;
public class Solution {
	public static int cutRod(int price[], int n){
        int dp[]= new int[n+1];
		
		for(int i=0;i<n+1;i++){
			dp[i]=i*price[0];
		}
		
		for(int i=1;i<n;i++){
			for(int j=0;j<n+1;j++){
				int take = Integer.MIN_VALUE;
				if(i+1<=j)take = price[i] + dp[j-(i+1)];
				int nottake= dp[j];

				dp[j]=Math.max(take,nottake);
			}
		}
        

	   return dp[n];
	}
}
  

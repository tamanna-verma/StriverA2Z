01.Recursion 

import java.util.* ;
import java.io.*; 
public class Solution {
	public static int countPartitions(int n, int d, int[] arr)
	{
	   // so we need to have the partitions with given difference 
	   // si+s2=total
	   // s1= total-s2
	   // total-s1-s1=d;
	   // total-d= 2s1;
	   //(total-d) /2 = s1;
       // so we need no.of partitions have sum s1
	   // get the number of ways in which sum of partition is s1;

   int total=0;
	 for(int i=0;i<n;i++){
		 total+=arr[i];
	 }
     if(total<d || (total-d)%2==1)return 0;
	 int sum1 = (total-d)/2;
	 int ans= helper(n-1 , sum1, arr);
      return ans;
	}
	    public static int helper(int index ,int target , int arr[]){
        // if(target==0 && arr[0]==0)return 2;
        // if(target==0 || (index==0 && target==arr[index]))return 1;
		//ye isliye nhi chlega kyuki agar target 0 hogya to starting vale 0's ko skip krdega 
		
		if(index<0){
			if(target==0)return 1;
			else return 0;
		} // base case target pe depend hi ni krra

        int pick = 0;
        if(target>=arr[index])pick=helper(index-1,target-arr[index],arr);
        int notpick = helper(index-1, target, arr);

       return (pick+notpick)%((int)1e9+7);
    }

02.Memoization - Top Down 

  import java.util.* ;
import java.io.*; 
public class Solution {
	public static int countPartitions(int n, int d, int[] arr)
	{
     int total=0;
	 for(int i=0;i<n;i++){
		 total+=arr[i];
	 }
     if(total<d || (total-d)%2==1)return 0;
	 int sum1 = (total-d)/2;

	 int dp[][]= new int [n][sum1+1];
	 for(int i=0;i<n;i++){
		 Arrays.fill(dp[i],-1);
	 }
	 int ans= helper(n-1 , sum1, arr , dp);
      return ans;
	}
	    public static int helper(int index ,int target , int arr[] , int [][]dp){
        // if(target==0 && arr[0]==0)return 2;
        // if(target==0 || (index==0 && target==arr[index]))return 1;
		//ye isliye nhi chlega kyuki agar target 0 hogya to starting vale 0's ko skip krdega 
		
		if(index<0){
			if(target==0)return 1;
			else return 0;
		} // base case target pe depend hi ni krra
        
		if(dp[index][target]!=-1)return dp[index][target];
        int pick = 0;
        if(target>=arr[index])pick=helper(index-1,target-arr[index],arr,dp);
        int notpick = helper(index-1, target, arr,dp);

       return dp[index][target]= (pick+notpick)%((int)1e9+7);
    }
}


04.SPACE OPTIMIZATION 

  import java.util.* ;
import java.io.*; 
public class Solution {
public static int countPartitions(int n, int d, int[] arr)
	{
     int total=0;
	 for(int i=0;i<n;i++){
		 total+=arr[i];
	 }
     if(total<d || (total-d)%2==1 )return 0;
	  int target = (total-d)/2;
      int dp[]= new int [target+1];
         dp[0]=1;
		 

		 if(arr[0]<=target)dp[arr[0]]=1;
		 if(arr[0]==0)dp[0]=2;

		 for(int ind=1;ind<n;ind++){
			 int temp[]=new int [target+1];
			 for(int tar =0;tar<target+1 ; tar++){

				 int pick =0;
                 if(arr[ind]<=tar) pick = dp[tar-arr[ind]];
				  int notpick = dp[tar];
				  temp[tar]=(pick+notpick)%((int)(1e9)+7);
			 }
			 dp=temp;
		 }
          return dp[target] %((int)(1e9)+7);
        }
}

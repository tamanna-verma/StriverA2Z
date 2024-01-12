1. Memoization - TopDownApproach

import java.util.Scanner;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int dp[]=new int [n+1];
		Arrays.fill(dp, -1);
		int ans = Fibonacci(n, dp);

		 System.out.println(ans);
	}
	public static int Fibonacci( int n , int [] dp ){
		if(n<=1)return n;

		if(dp[n]!=-1)return dp[n];
		return dp[n]= Fibonacci(n-1, dp)+Fibonacci(n-2, dp);

	}
}

2. Tabulation - Bottom Up
  
class Solution
{
    public int fib(int n) 
    {
       int dp[]=new int [n+1];
       dp[0]=0;
       dp[1]=1;
       for(int i =2;i<=n;i++){
           dp[i]=dp[i-1]+dp[i-2];
       }
       return dp[n];
    }
}

3. Optimised Approach
  
class Solution
{
    public int fib(int n) 
    {
        if(n<=1)return n;
       int prev2= 0;
       int prev = 1;
       for(int i=2;i<=n;i++){
           int curr= prev2+prev;
           prev2=prev;
           prev=curr;
       }
       return prev;
    }
}

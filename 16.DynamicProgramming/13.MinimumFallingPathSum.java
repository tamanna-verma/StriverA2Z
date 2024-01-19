01.Recursion
  
class Solution 
{
    public int minFallingPathSum(int[][] matrix) {
        
        int n=matrix.length;
        int m=matrix[0].length;
         
        int minlast = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            minlast =Math.min(minlast , helper(n-1,i,matrix));
        }
        return minlast;
    }

    public int helper( int n , int m , int[][] matrix){
        if(m<0 || m>= matrix[0].length)return (int)1e9;
        if(n==0) return matrix[n][m];
         
        int dy []={-1,0,+1};
        int min =Integer.MAX_VALUE;
        for(int i=0;i<dy.length;i++) min = Math.min(min,helper(n-1 ,m+dy[i], matrix)); 
        return min + matrix[n][m];
    }
}

02.Memoization -Top Down 

  //Coding ninjas - 
  Maximum Path Sum In The Matrix


import java.util.* ;
import java.io.*; 

public class Solution {
	public static int getMaxPathSum(int[][] matrix) {
		 int n=matrix.length;
        int m=matrix[0].length;
        int[][]dp = new int [n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
         
        int maxlast = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            maxlast =Math.max(maxlast , helper(n-1,i,matrix, dp));
        }
        return maxlast;
	}
	  public static int helper( int n , int m , int[][] matrix, int[][]dp){
        if(m<0 || m>= matrix[0].length)return (int)-1e9;
        if(n==0) return dp[n][m]= matrix[n][m];
         
         if(dp[n][m]!=-1)return dp[n][m];
        int dy []={-1,0,+1};
        int max =Integer.MIN_VALUE;
        for(int i=0;i<dy.length;i++) max = Math.max(max,helper(n-1 ,m+dy[i], matrix,dp)); 
        return dp[n][m]=max + matrix[n][m];
    }
}
Memoization -Top Down
//Leetcode - TLE 

class Solution 
{
    public int minFallingPathSum(int[][] matrix) {
        
        int n=matrix.length;
        int m=matrix[0].length;
        int[][]dp = new int [n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
         
        int minlast = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            minlast =Math.min(minlast , helper(n-1,i,matrix, dp));
        }
        return minlast;
    }

    public int helper( int n , int m , int[][] matrix, int[][]dp){
        if(m<0 || m>= matrix[0].length)return (int)1e9;
        if(n==0) return dp[n][m]= matrix[n][m];
         
         if(dp[n][m]!=-1)return dp[n][m];
        int dy []={-1,0,+1};
        int min =Integer.MAX_VALUE;
        for(int i=0;i<dy.length;i++) min = Math.min(min,helper(n-1 ,m+dy[i], matrix,dp)); 
        return dp[n][m]=min + matrix[n][m];
    }
}

03.Tabulation 

  class Solution 
{
    public int minFallingPathSum(int[][] matrix) {
        
        int n=matrix.length;
        int m=matrix[0].length;
        int[][]dp = new int [n][m];
        for(int i=0;i<m;i++){
            dp[0][i]=matrix[0][i];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                
                int topleft = Integer.MAX_VALUE;
                int topright =Integer.MAX_VALUE;
                if(j-1>=0)topleft = dp[i-1][j-1];
                if(j+1<m)topright = dp[i-1][j+1];
                int up = dp[i-1][j];
                int min=Math.min(topleft , Math.min(topright , up)) ;
                dp[i][j]=min + matrix[i][j];
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            min=Math.min(min , dp[n-1][i]);
        }

        return min; 
       
    }
}

//04.Space Optimization 

class Solution 
{
    public int minFallingPathSum(int[][] matrix) {
        
        int n=matrix.length;
        int m=matrix[0].length;
        int[]dp = new int [m];
        for(int i=0;i<m;i++){
            dp[i]=matrix[0][i];
        }

        for(int i=1;i<n;i++){
            int []temp=new int [m];
            for(int j=0;j<m;j++){
                
                int topleft = Integer.MAX_VALUE;
                int topright =Integer.MAX_VALUE;
                if(j-1>=0)topleft = dp[j-1];
                if(j+1<m)topright = dp[j+1];
                int up = dp[j];
                int min=Math.min(topleft , Math.min(topright , up)) ;
                temp[j]=min + matrix[i][j];
            }
            dp=temp;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            min=Math.min(min , dp[i]);
        }

        return min; 
       
    }
}

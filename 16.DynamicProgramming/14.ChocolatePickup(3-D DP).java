//01.Recursion 

import java.util.* ;
import java.io.*; 
public class Solution {
	public static int maximumChocolates(int r, int c, int[][] grid) {
	             // i , j1 , j2
		int n=grid.length;
		int m=grid[0].length;
	return helper(0 ,0 ,m-1, grid);
	}
	public static int helper( int i , int j1, int j2 , int[][]grid )
	{
		int n=grid.length;
		int m=grid[0].length;
	if(j1<0 || j2<0 || j1>=m || j2>=m)return -(int)1e9;

    if(i==n-1){
		if(j1==j2)return grid[n-1][j1];
		else return grid[n-1][j1]+grid[n-1][j2];
	}

	int deltaX[]={-1,0,+1};

    int max=Integer.MIN_VALUE;
	for(int dj1 =0;dj1<deltaX.length;dj1++){
		for(int dj2=0;dj2<deltaX.length;dj2++){
			int newj1=deltaX[dj1]+j1;
			int newj2=deltaX[dj2]+j2;
        int val =0;
		if(j1==j2)val= grid[i][j1]+ helper(i+1 ,newj1,newj2 ,grid);
		else val = grid[i][j1]+ grid[i][j2] + helper(i+1 , newj1 , newj2 , grid);
		max=Math.max(max , val);
		}
	}
return max;

	}
}

//02.Memoization -Top Down - if there are fixed starting point , and multiple ending point , then recursion will start from start and go towards end
// and tabulation will be in opposite direction of memoization 

import java.util.* ;
import java.io.*; 
public class Solution {
	public static int maximumChocolates(int r, int c, int[][] grid) {
	             // i , j1 , j2
		int m=grid[0].length;
		int [][][]dp = new int [n][m][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				for(int k=0;k<m;k++)
				{
					dp[i][j][k]=-1;
				}
			}
		}
	return helper(0 ,0 ,m-1, grid, dp);
	}
	public static int helper( int i , int j1, int j2 , int[][]grid , int [][][]dp )
	{
		int n=grid.length;
		int m=grid[0].length;
	if(j1<0 || j2<0 || j1>=m || j2>=m)return -(int)1e9;
    if(i==n-1)
	{
		if(j1==j2)return dp[i][j1][j2]=grid[n-1][j1];
		else return dp[i][j1][j2]= grid[n-1][j1]+grid[n-1][j2];
	}
     
	 if(dp[i][j1][j2]!=-1)return dp[i][j1][j2];
	int deltaX[]={-1,0,+1};

    int max=Integer.MIN_VALUE;
	for(int dj1 =0;dj1<deltaX.length;dj1++){
		for(int dj2=0;dj2<deltaX.length;dj2++){
			int newj1=deltaX[dj1]+j1;
			int newj2=deltaX[dj2]+j2;
        int val =0;
		if(j1==j2)val= grid[i][j1]+ helper(i+1 ,newj1,newj2 ,grid,dp);
		else val = grid[i][j1]+ grid[i][j2] + helper(i+1 , newj1 , newj2 , grid,dp);
		max=Math.max(max , val);
		}
	}
return dp[i][j1][j2]=max;

	}
}

//03.Tabulation - Bottom Up 

import java.util.* ;
import java.io.*; 
public class Solution {
	public static int maximumChocolates(int r, int c, int[][] grid)
	{
	        //tabulation 
		//top down 
		//base case , n-1 row 
		int [][][]dp= new int [r][c][c];

        int row=r-1;
		for(int j1=0;j1<c;j1++){
			for(int j2=0;j2<c;j2++){
				if(j1==j2)dp[row][j1][j2]=grid[row][j1];
				else dp[row][j1][j2]=grid[row][j1]+grid[row][j2];
			}
		}

		
		int deltaX[]={-1,0,+1};

		for(int i=r-2;i>=0;i--){
			for(int j1=c-1;j1>=0;j1--){
				for(int j2=c-1;j2>=0;j2--){
                   int max=0; 
				   for(int dx=0;dx<deltaX.length;dx++){
					   for(int dy=0;dy<deltaX.length;dy++){
                          
						   int newj1=j1+deltaX[dx];
						   int newj2=j2+deltaX[dy];
                         if(newj1<0 || newj2<0 || newj1>=c ||newj2>=c)continue;
                            
						   max=Math.max(max , dp[i+1][newj1][newj2]);
					   }
				   }
				   int val = 0;
                   if(j1==j2)val+= grid[i][j1]+max;
				   else val += grid[i][j1]+ grid[i][j2]+max;
				   dp[i][j1][j2]=val;
				   
				}
			}
		}
	  return dp[0][0][c-1];
	}
}

04.SPACE OPTIMIZATION - 
1D DP - 2 variable
2D DP - 1D DP
3D DP - 2D DP

  import java.util.* ;
import java.io.*; 
public class Solution {
	public static int maximumChocolates(int r, int c, int[][] grid)
	{
	        //tabulation 
		//top down 
		//base case , n-1 row 
		int [][]dp= new int [c][c];

        int row=r-1;
		for(int j1=0;j1<c;j1++){
			for(int j2=0;j2<c;j2++){
				if(j1==j2)dp[j1][j2]=grid[row][j1];
				else dp[j1][j2]=grid[row][j1]+grid[row][j2];
			}
		}

		
		int deltaX[]={-1,0,+1};

		for(int i=r-2;i>=0;i--)
		{
			int [][]temp=new int [c][c];
			for(int j1=c-1;j1>=0;j1--)
			{
				for(int j2=c-1;j2>=0;j2--)
				{
                   int max=0; 

				   for(int dx=0;dx<deltaX.length;dx++){
					   for(int dy=0;dy<deltaX.length;dy++){
                          
						   int newj1=j1+deltaX[dx];
						   int newj2=j2+deltaX[dy];
                         if(newj1<0 || newj2<0 || newj1>=c ||newj2>=c)continue;
                            
						   max=Math.max(max , dp[newj1][newj2]);
					   }
				   }
				   int val = 0;
                   if(j1==j2)val+= grid[i][j1]+max;
				   else val += grid[i][j1]+ grid[i][j2]+max;
				   temp[j1][j2]=val;
				   
				}
           
			}
			dp=temp;
		}
	  return dp[0][c-1];
	}
}

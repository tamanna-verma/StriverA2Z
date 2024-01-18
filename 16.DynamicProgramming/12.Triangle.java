//01.Recursion

class Solution {
    public int minimumTotal(List<List<Integer>> triangle)
    {
        //recursion 
         return helper(0,0,triangle);
        
    }
    public int helper(int n , int m ,List<List<Integer>> triangle){
        if(n==triangle.size()-1){
            return triangle.get(n).get(m);
        }

        int min=Integer.MAX_VALUE;
        for(int i=0;i<triangle.get(n).size();i++){
            int currcol=helper(n+1,m,triangle);
            int nextcol=helper(n+1,m+1,triangle);

            min=Math.min(currcol,nextcol);
        }
        return min+triangle.get(n).get(m);
    }
}

02.Memoization -Top Down
  //leetcode

  class Solution {
    public int minimumTotal(List<List<Integer>> triangle)
    {
        List<List<Integer>> dp=new ArrayList();
        for(int i=0;i<triangle.size();i++){
            triangle.add(new ArrayList<Integer>());
        }

        for(int i=0;i<triangle.size();i++){
            for(int j=0;j<triangle.get(i).size();j++){
                triangle.get(i).add(-1);
            }
        }
         return helper(0,0,triangle, dp);
        
    }
    public int helper(int n , int m ,List<List<Integer>> triangle,List<List<Integer>> dp){
        if(n==triangle.size()-1){
            dp.get(n).set(m,triangle.get(n).get(m));
             return triangle.get(n).get(m);
        }

        if(dp.get(n).get(m)!=-1)return dp.get(n).get(m);
        int min=Integer.MAX_VALUE;

        for(int i=0;i<triangle.get(n).size();i++){
            int currcol=helper(n+1,m,triangle,dp);
            int nextcol=helper(n+1,m+1,triangle,dp);

            min=Math.min(currcol,nextcol);
        }

         dp.get(n).set(m,min+triangle.get(n).get(m));
         return min+triangle.get(n).get(m);
    }
}

//coding ninjas
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumPathSum(int[][] triangle, int n) {
      int [][]dp=new int [triangle.length][];
      for(int i=0;i<triangle.length;i++){
          dp[i]=new int [triangle[i].length];
          Arrays.fill(dp[i],-1);
      }
       
         return helper(0,0,triangle, dp);
        
    }
     public static int helper(int n , int m ,int[][] triangle,int[][] dp){
        if(n==triangle.length-1){
            return dp[n][m]=triangle[n][m];
          
        }

        if(dp[n][m]!=-1)return dp[n][m];
        int min=Integer.MAX_VALUE;

        for(int i=0;i<triangle[n].length;i++){
            int currcol=helper(n+1,m,triangle,dp);
            int nextcol=helper(n+1,m+1,triangle,dp);

            min=Math.min(currcol,nextcol);
        }

         dp[n][m]=min+triangle[n][m];
         return min+triangle[n][m];
    }
}

03.Tabulation - Bottom Up 

  //coding ninjas
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumPathSum(int[][] triangle, int n) {
      int [][]dp=new int [triangle.length][];
      for(int i=0;i<triangle.length;i++)
      {
          dp[i]=new int [triangle[i].length];
          Arrays.fill(dp[i],-1);
      }
     
           
           for (int i = 0; i < triangle[n-1].length; i++) {
            dp[n-1][i]= triangle[n-1][i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = triangle[i].length - 1; j >= 0; j--) {
                int first = dp[i+1][j];
                int second = dp[i + 1][j+1];
                int min = Math.min(first, second);
                int val = min + triangle[i][j];
                dp[i][j]= val;
            }
        }
        return dp[0][0];
        
    }
     
}

04.Space Optimization



class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // now we need to do it using tabulation , tabulation starts from the base case
       int n=triangle.size();
       int []dp= new int [triangle.get(n-1).size()];
       for(int i=0;i<dp.length;i++)dp[i]=triangle.get(n-1).get(i);
      
        for (int i = n - 2; i >= 0; i--) {
            int []temp= new int[triangle.get(i).size()];

            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                int first = dp[j];
                int second = dp[j+1];
                int min = Math.min(first, second);
                int val = min + triangle.get(i).get(j);
                temp[j]= val;
            }
            dp=temp;
        }
        return dp[0];
    }
}

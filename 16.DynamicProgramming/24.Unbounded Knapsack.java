01.RECURSION

  public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
       
       int ans= helper(n-1 , w , profit , weight);
       return ans;
    }
    public static int helper(int index , int bagspace , int profit[] , int weight[]){
        
        if(index==0)
        {
          return ((int)(bagspace/weight[index]))*profit[index];
        }


        int take=Integer.MIN_VALUE;
        if(bagspace>=weight[index]){
            take=profit[index]+helper(index , bagspace-weight[index], profit , weight);
        }
        int nottake= helper(index-1, bagspace,profit , weight);

        return Math.max(take,nottake);
    }
    
}


02.MEMOIZAION - TOP DOWN
import java.util.*;
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
       int dp[][]= new int [n][w+1];
       for(int i=0;i<n;i++)
       {
           Arrays.fill(dp[i],-1);
       }
       int ans= helper(n-1 , w , profit , weight,dp);
       return ans;
    }
    public static int helper(int index , int bagspace , int profit[] , int weight[], int [][]dp){
        
        if(index==0)
        {
          return ((int)(bagspace/weight[index]))*profit[index];
        }
        if(dp[index][bagspace]!=-1)return dp[index][bagspace];


        int take=Integer.MIN_VALUE;
        if(bagspace>=weight[index]){
            take=profit[index]+helper(index , bagspace-weight[index], profit , weight,dp);
        }
        int nottake= helper(index-1, bagspace,profit , weight,dp);

        return dp[index][bagspace]= Math.max(take,nottake);
    }
    
}



03.TABULATION - BOTTOM UP 
import java.util.*;
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
       int dp[][]= new int [n][w+1];
       
       for(int j=weight[0];j<w+1;j++){
          dp[0][j]=(int)(j/weight[0])*profit[0];
       }
        for(int i=1;i<n;i++){
            for(int j=0;j<w+1;j++){
              
              int take=0;
              if(weight[i]<=j)take=profit[i]+dp[i][j-weight[i]];
              int nottake=dp[i-1][j];

                dp[i][j]=Math.max(take,nottake);
            }
        }
      
        return dp[n-1][w];
    }
    
}


04.SPACE OPTIMIZATION -2 ARRAY 
import java.util.*;
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
       int dp[]= new int [w+1];
       
       for(int j=weight[0];j<w+1;j++){
          dp[j]=(int)(j/weight[0])*profit[0];
       }
        for(int i=1;i<n;i++){
            int []temp = new int [w+1];
            for(int j=0;j<w+1;j++){
              
              int take=0;
              if(weight[i]<=j)take=profit[i]+temp[j-weight[i]];
              int nottake=dp[j];

                temp[j]=Math.max(take,nottake);
            }
            dp=temp;
        }
      
        return dp[w];
    }
    
}

05.SPACE OPTIMIZATION - 1 ARRAY 

  import java.util.*;
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
       int dp[]= new int [w+1];
       
       for(int j=weight[0];j<w+1;j++){
          dp[j]=(int)(j/weight[0])*profit[0];
       }
        for(int i=1;i<n;i++){
           
            for(int j=0;j<w+1;j++){
              
              int take=0;
              if(weight[i]<=j)take=profit[i]+dp[j-weight[i]];
              int nottake=dp[j];

                dp[j]=Math.max(take,nottake);
            }
           
        }
      
        return dp[w];
    }
    
}



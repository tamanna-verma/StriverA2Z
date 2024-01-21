01.RECURSION


import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
           
      int ans = helper(n-1 , weight , value ,0, maxWeight );
          return ans;
    }

    public static int helper(int index , int []weight , int value[] , int totalvalue  , int maxweight){
     if(index==0){
          if(weight[0]<=maxweight)return value[0];
          else return 0;
      }
       
   
      int pick=Integer.MIN_VALUE;
      if(maxweight>=weight[index]) pick=helper(index-1 , weight , value , totalvalue, maxweight-weight[index])   + value[index] ;

      int notpick = helper(index-1, weight , value , totalvalue , maxweight);

      return Math.max(pick , notpick);
    }
}

02.MEMOIZATION -Top Down

import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
           
           int dp[][]=new int [n][maxWeight+1];
           for(int i=0;i<n;i++){
               Arrays.fill(dp[i],-1);
           }
          int ans = helper(n-1 , weight , value ,0, maxWeight,dp );
          return ans;
    }

    public static int helper(int index , int []weight , int value[] , int totalvalue  , int maxweight, int dp[][]){
      if(index==0){
          if(weight[0]<=maxweight)return value[0];
          else return 0;
      }
       if(dp[index][maxweight]!=-1)return dp[index][maxweight];
      int pick=Integer.MIN_VALUE;
      if(maxweight>=weight[index]) pick=helper(index-1 , weight , value , totalvalue, maxweight-weight[index],dp)   + value[index] ;

      int notpick = helper(index-1, weight , value , totalvalue , maxweight,dp);

      return dp[index][maxweight] =Math.max(pick , notpick);
    }
}


03.TABULATION - BOTTOM UP 

import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
           
    int dp[][]=new int [n][maxWeight+1];
          for(int i=weight[0];i<=maxWeight;i++){
             dp[0][i]=value[0];
          }
         

          for(int index=1;index<n;index++)
          {
              for(int wt =0;wt<=maxWeight;wt++){
                 
                 int take = Integer.MIN_VALUE;
                 if(weight[index]<=wt)take=value[index]+dp[index-1][wt-weight[index]];
                 int nottake = dp[index-1][wt];

                 dp[index][wt]=Math.max(take,nottake);
              }
          }
      return dp[n-1][maxWeight];
    }
}


04. SPACE OPTIMIZATION - TO 2 1-D ARRAY


import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
           
    int dp[]=new int [maxWeight+1];
          for(int i=weight[0];i<=maxWeight;i++){
             dp[i]=value[0];
          }
 
          for(int index=1;index<n;index++)
          {
                int temp[]=new int [maxWeight+1];
              for(int wt =0;wt<=maxWeight;wt++){
                 
                 int take = Integer.MIN_VALUE;
                 if(weight[index]<=wt)take=value[index]+dp[wt-weight[index]];
                 int nottake = dp[wt];

                 temp[wt]=Math.max(take,nottake);
              }
              dp=temp;
          }
      return dp[maxWeight];
    }
}


05.SPACE OPTIMIZATION - TO 1 1-D ARRAY 


// temp wt fill krne k liye dp k start vale rows ki jroorat pdri hai , to end se dp ko hi fill krte chlte hai , will new dp values , start valo values to rhegi hi
//   [wt]dp[wt-weight[index]];
  
import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
           
    int dp[]=new int [maxWeight+1];
          for(int i=weight[0];i<=maxWeight;i++){
             dp[i]=value[0];
          }
 
          for(int index=1;index<n;index++)
          {
               
              for(int wt=maxWeight;wt>=0;wt--){
                 
                 int take = Integer.MIN_VALUE;
                 if(weight[index]<=wt)take=value[index]+dp[wt-weight[index]];
                 int nottake = dp[wt];

                 dp[wt]=Math.max(take,nottake);
              }
              
          }
      return dp[maxWeight];
    }
}


// We will  initialize the first row and then using its values we will the next row.

// If we clearly see the values required:  dp[ind-1][cap] and dp[ind-1][cap – wt[ind]], we can say that if we are at a column cap, we will only require the values shown in the green region and none in the red region shown in the below image ( because cap – wt[ind] will always be less than the cap).

// As we don’t want values from the right, we can start filling this new row from the right rather than the left.

// Now here is the catch, if we are filling from the right and at any time we need the previous row’s value of the leftward columns only, why do we need to have two rows in the first place? We can use a single row and overwrite the new computed values on itself in order to store it.

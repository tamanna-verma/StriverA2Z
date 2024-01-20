01.Recursion 

import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
       
     //here we need to get the sum equal to k =target

     boolean ans = helper(n-1 , k , arr);
     return ans;
    }
     public static boolean helper(int index , int target , int arr[]){
        if(target==0)return true;
        if(index==0 && target ==arr[index])return true;
        if(index<0)return false;

        boolean pick = false;
        if(arr[index]<=target)pick = helper(index-1 , target-arr[index] , arr);
        boolean notpick = helper(index-1 , target , arr);

        return pick || notpick;
    }
}

02.Memoization - Top Down

  import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
       
//here we need to get the sum equal to k =target
// int the recursive function , what all parameters are changing , index , and target 
// so the dp array will be having 2 dimensions - target and index
// index can be at max of arr size , and target can be at max of k size

     int dp[][]= new int [n][k+1];
     for(int i=0;i<dp.length;i++){
         Arrays.fill(dp[i],-1);
     }
     boolean ans = helper(n-1 , k , arr , dp);
     return ans;
    }
    public static boolean helper(int index , int target , int arr[] , int [][]dp){
        if(target==0)
        {   dp[index][target]=1;
            return true;
        }
        if(index==0 && target ==arr[index])
        {   
            dp[index][target]=1;
            return true;
        }
        if(index<0)return false;
         
         if(dp[index][target]!=-1)return dp[index][target]==1?true:false;

        boolean pick = false;
        if(arr[index]<=target)pick = helper(index-1 , target-arr[index] , arr , dp);
        boolean notpick = helper(index-1 , target , arr , dp);
         
        if(pick||notpick){
            dp[index][target]=1;
        }
        else dp[index][target]=0;

        return pick || notpick;
    }
}

03.Tabulation 

  import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
       
//here we need to get the sum equal to k =target
// int the recursive function , what all parameters are changing , index , and target 
// so the dp array will be having 2 dimensions - target and index
// index can be at max of arr size , and target can be at max of k size

     int dp[][]= new int [n][k+1];
     for(int i=0;i<dp.length;i++){
         Arrays.fill(dp[i],-1);
     }
     for(int i=0;i<n;i++){
        dp[i][0]=1;
     }
    if(arr[0]<=k)  dp[0][arr[0]]=1;
   
      
      for(int i=1;i<n;i++){
          for(int j=0;j<k+1;j++){
              
              int pick=0;
              int val = arr[i];
              if(j>=val){
                 pick = dp[i-1][j-val];
              }
              int notpick=0;
              notpick = dp[i-1][j];
              if(pick==1 || notpick==1)dp[i][j]=1;
              else dp[i][j]=0;

          }
      }
      return dp[n-1][k]==1;
    }
}

04.Space Optimization 

  import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
       
//here we need to get the sum equal to k =target
// int the recursive function , what all parameters are changing , index , and target 
// so the dp array will be having 2 dimensions - target and index
// index can be at max of arr size , and target can be at max of k size

     int dp[]= new int [k+1];
     dp[0]=1;
    if(arr[0]<=k)  dp[arr[0]]=1; 

      for(int i=1;i<n;i++){
          int []temp = new int[k+1];

          for(int j=0;j<k+1;j++){
              
              int pick=0;
              int val = arr[i];
              if(j>=val){
                 pick = dp[j-val];
              }
              int notpick=0;
              notpick = dp[j];
              if(pick==1 || notpick==1)temp[j]=1;
              else temp[j]=0;

          }
          dp=temp;
      }
      return dp[k]==1;
    }
}

  
  

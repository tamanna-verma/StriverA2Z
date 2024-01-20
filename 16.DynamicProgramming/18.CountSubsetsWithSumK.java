01.RECURSION 
  
import java.util.*;
import java.io.*;

public class Solution {
    public static int findWays(int num[], int tar)
    {
       int n=num.length;
       int ans = helper(n-1 , tar, num);
       return ans;
    }
    public static int helper(int index ,int target , int arr[]){
        if(target==0 && arr[0]==0)return 2;
        if(target==0 || (index==0 && target==arr[index]))return 1;
        if(index<0)return 0;

        int pick = 0;
        if(target>=arr[index])pick=helper(index-1,target-arr[index],arr);
        int notpick = helper(index-1, target, arr);

       return (pick+notpick)%((int)(1e9)+7);
    }
}

02.MEMOIZATION -TOP DOWN
  
import java.util.*;
import java.io.*;

public class Solution {
    public static int findWays(int num[], int tar)
    {
       int n=num.length;
       int dp[][]=new int [n][tar+1];
       for(int i=0;i<n;i++){
           Arrays.fill(dp[i],-1);
       }
       int ans = helper(n-1,tar, num,dp);
       return ans%(((int)1e9)+7);
    }
    
    //if target is 0 and arr[0]==0, then there can be 2 cases , where 1 is 
public static int helper(int index ,int target , int arr[], int dp[][]){
      if( index==0 )
        {   
            if(target==0 && arr[index]==0)return dp[index][target]=2;
            if(target==0 || target==arr[0]) return dp[index][target]=1;
            return 0;
        }

     
          //if(index==0 && target==0)return 1;
         if(index<0)return 0;

         if( dp[index][target]!=-1)return  dp[index][target];
        int pick = 0;
        if(target>=arr[index])pick=helper(index-1,target-arr[index],arr,dp);
        int notpick = helper(index-1, target, arr,dp);

       return dp[index][target]= (pick + notpick )%(((int)1e9)+7);
    }
}


03.TABULATION - BOTTOM UP 

    import java.util.*;
import java.io.*;

public class Solution {
    public static int findWays(int num[], int target)
    {
       int n=num.length;
      int dp[][]= new int [n][target+1];
      int index=0;
      
      for(int i=0;i<n;i++){
          dp[i][0]=1;
      }
       if(num[0]==0)dp[0][0]=2;
       else if(num[0]<=target)
       { 
         dp[0][num[0]]=1;
       }
       
       for(int i=1;i<n;i++){
           for(int j=0;j<target+1;j++){

               int pick=0;
               if(num[i]<=j)pick = dp[i-1][j-num[i]];
               int notpick = dp[i-1][j];

               dp[i][j]=(pick + notpick )%((int)(1e9)+7);
           }
       }
       return dp[n-1][target]%((int)(1e9)+7);
      //here we need to have how many ways we can get the desired target 

    }
}


04.SPACE OPTIMIZATION 

  import java.util.*;
import java.io.*;

public class Solution {
    public static int findWays(int num[], int target)
    {
       int n=num.length;
      int dp[]= new int [target+1];
      int index=0;
     if(num[0]==0 )dp[0]=2;
     else 
     dp[0]=1;
     if(num[0]!=0 && num[0]<=target) dp[num[0]]=1;

 
       
       for(int i=1;i<n;i++){
           int temp[]=new int [target+1];
           for(int j=0;j<target+1;j++){
             
               int pick=0;
               if(num[i]<=j)pick = dp[j-num[i]];
               int notpick = dp[j];

               temp[j]=(pick + notpick )%((int)(1e9)+7);
           }
           dp=temp;
       }
       return dp[target]%((int)(1e9)+7);
      //here we need to have how many ways we can get the desired target 

    }
}

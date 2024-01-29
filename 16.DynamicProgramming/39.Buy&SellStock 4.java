01.RECURSION //using 2-d DP , converting buy into trans%2 ans sell into trans%2==1
class Solution {
    public int maxProfit(int k, int[] prices) {
//for buy and sell , we will maintain transaction no. if the transaction no. is odd , then we need to buy and when its even then we need to sell 
k=k *2;
int trans=0;
int ans = helper(0,trans,prices,k);
return ans;
    }
  public int helper(int index ,int trans , int []prices , int k ){
        if(index==prices.length)return 0;
        if(trans==k)return 0;
        

         int profit =0;
        if(trans%2==0){//buy
           
           int take= -1*prices[index] + helper(index+1 , trans+1 , prices , k);
           int nottake = helper(index+1 , trans , prices , k );
           return Math.max(take , nottake);
        }
        else{//sell
            int take = prices[index]+helper(index+1 , trans+1 , prices , k);
            int nottake = helper(index+1 , trans , prices , k);
            return Math.max(take , nottake);
        }
    }
}
02.MEMOIZATION - TOP DOWN 
  
class Solution {
    public int maxProfit(int k, int[] prices) {
//for buy and sell , we will maintain transaction no. if the transaction no. is odd , then we need to buy and when its even then we need to sell 
k=k *2;
int trans=0;
int dp[][]=new int [prices.length][k];
for(int i=0;i<prices.length;i++)Arrays.fill(dp[i],-1);
int ans = helper(0,trans,prices,k, dp);
return ans;
    }
  public int helper(int index ,int trans , int []prices , int k , int [][]dp){
        if(index==prices.length)return 0;
        if(trans==k)return 0;
        if(dp[index][trans]!=-1)return dp[index][trans];

         int profit =0;
        if(trans%2==0){//buy
           
           int take= -1*prices[index] + helper(index+1 , trans+1 , prices , k,dp);
           int nottake = helper(index+1 , trans , prices , k ,dp);
           return dp[index][trans]=Math.max(take , nottake);
        }
        else{//sell
            int take = prices[index]+helper(index+1 , trans+1 , prices , k, dp);
            int nottake = helper(index+1 , trans , prices , k, dp);
            return dp[index][trans]= Math.max(take , nottake);
        }
    }
    

}
03.TABULATION 

  class Solution {
    public int maxProfit(int k, int[] prices) 
    {
//for buy and sell , we will maintain transaction no. if the transaction no. is odd , then we need to buy and when its even then we need to sell 
k = k * 2;
int trans=0;
int n=prices.length;
int dp[][]=new int [n+1][k+1];

for(int i=n-1;i>=0;i--)
{
    for(int j=0;j<k;j++)
    {
    int profit =0;
    int max=0;
    if(j%2==0)//buy
    {
        int take = (-1 * prices[i] ) + dp[i + 1][j + 1];
        int nottake = dp[i+1][j];
         max = Math.max(take , nottake);
       
    }
    else
     {
         int take = prices[i] + dp[i+1][j+1];
        int nottake = dp[i+1][j];
        max = Math.max(take , nottake);
        
     }
     dp[i][j]=max;
  }
}
return dp[0][0];
    }
}

4.SPACE OPIMIZATION = T0 2 1D ARRAY

  class Solution {
    public int maxProfit(int k, int[] prices) 
    {
//for buy and sell , we will maintain transaction no. if the transaction no. is odd , then we need to buy and when its even then we need to sell 
k = k * 2;
int trans=0;
int n=prices.length;
int dp[]=new int [k+1];

for(int i=n-1;i>=0;i--)
{
    int temp[]= new int [k+1];
    for(int j=0;j<k;j++)
    {
    int profit =0;
    int max=0;
    if(j%2==0)//buy
    {
        int take = (-1 * prices[i] ) + dp[j + 1];
        int nottake = dp[j];
         max = Math.max(take , nottake);
       
    }
    else
     {
         int take = prices[i] + dp[j+1];
        int nottake = dp[j];
        max = Math.max(take , nottake);
        
     }
     temp[j]=max;
  }
  dp=temp;
}
return dp[0];
    }
}

5.SPACE OPTIMIZATION - TO 1-D ARRAY 
  
class Solution {
  public int maxProfit(int k, int[] prices) 
  {
//for buy and sell , we will maintain transaction no. if the transaction no. is odd , then we need to buy and when its even then we need to sell 
k = k * 2;
int trans=0;
int n=prices.length;
int dp[]=new int [k+1];

for(int i=n-1;i>=0;i--)
{
  
    for(int j=0;j<k;j++)
    {
    int profit =0;
    int max=0;
    if(j%2==0)//buy
    {
        int take = (-1 * prices[i] ) + dp[j + 1];
        int nottake = dp[j];
         max = Math.max(take , nottake);
       
    }
    else
     {
         int take = prices[i] + dp[j+1];
        int nottake = dp[j];
        max = Math.max(take , nottake);
        
     }
    dp[j]=max;
  }
 
}
return dp[0];
    }
}


//USING 3-D DP
01.RECURSION

  class Solution {
    public int maxProfit(int k, int[] prices) {
        for(int i=0;i<prices.length;i++){Arrays.fill(dp[i],-1);}
        return helper(0,prices, 1,dp);
        return ans;
    }
     public int helper(int index ,int[] prices , Boolean buy , int cap){
        if(cap==0)return 0;
        if(index==prices.length)return 0;

         
        int buyprofit = 0;
        int sellprofit = 0;
        if(buy)
        {
         int take = helper(index+1 , prices , false , cap) - prices[index] ;
         int nottake = helper(index+1, prices , true , cap);
         buyprofit = Math.max(take,nottake);
        }
        else
        {
          int sellhere = helper(index+1 , prices ,true, cap-1) + prices[index];//sell krne k bad next buy se phle cap -- krte h 
          int sellfurther = helper(index+1,prices, false , cap);
           sellprofit= Math.max(sellhere,sellfurther);
        }
        return Math.max(buyprofit,sellprofit);
    }

}

02.MEMOIZATION 
  class Solution {
    public int maxProfit(int k, int[] prices) {
        //transaction*2
       int dp[][][]= new int [prices.length][2][k+1];
        for(int i=0;i<prices.length;i++)
        {
            for(int j=0;j<=1;j++)
            {
                Arrays.fill(dp[i][j],-1);
            }
        }
        int ans = helper(0,prices , 1 ,k, dp);
        return ans;
    }
  public int helper(int index ,int[] prices , int buy ,int cap, int [][][]dp){
        if(cap==0)return 0;
        if(index==prices.length)return 0;
        if(dp[index][buy][cap]!=-1)return dp[index][buy][cap];
         
        int buyprofit = 0;
        int sellprofit = 0;
        if(buy==1)
        {
         int take = helper(index+1 , prices , 0 , cap,dp) - prices[index] ;
         int nottake = helper(index+1, prices , 1 , cap,dp);
         buyprofit = Math.max(take,nottake);
        }
        else
        {
          int sellhere = helper(index+1 , prices ,1, cap-1,dp) + prices[index];//sell krne k bad next buy se phle cap -- krte h 
          int sellfurther = helper(index+1,prices,0 , cap,dp);
           sellprofit= Math.max(sellhere,sellfurther);
        }
        return dp[index][buy][cap]=Math.max(buyprofit,sellprofit);
    }

}


  

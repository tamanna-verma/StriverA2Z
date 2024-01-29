01.Recursion
  class Solution {
    public int maxProfit(int[] prices)
    {
        boolean buy = true;
        int ans= helper(0, buy, prices);
        return ans;
    }
    public int helper(int index ,boolean buy, int prices[]){
        if(index>=prices.length)return 0;

        if(buy){
        int take = helper(index+1, false, prices) - prices[index];
        int nottake = helper(index+1 , true , prices);
        return Math.max(take , nottake);
        }
        else{ //sell
        int take = helper(index+2, true, prices) + prices[index];
        int nottake = helper(index+1 , false , prices);
        return Math.max(take , nottake);
        }
    }
}

02.MEMOIZATION - TOP DOWN 
  class Solution {
    public int maxProfit(int[] prices)
    {
        int dp[][]= new int [prices.length][2];
        for(int i=0;i<prices.length;i++){Arrays.fill(dp[i],-1);}
        return helper(0,prices, 1,dp);
       
    }
     public int helper(int index ,int[] prices , int buy , int[][]dp){
         if(index>=prices.length)return 0;
        if(dp[index][buy]!=-1)return dp[index][buy];     
        int buyprofit = 0;
        int sellprofit = 0;
        if(buy==1)
        {
         int take = helper(index+1 , prices , 0,dp) - prices[index] ;
         int nottake = helper(index+1, prices , 1,dp);
         buyprofit = Math.max(take,nottake);
        }
        else
        {
          int sellhere = helper(index+2 , prices ,1,dp) + prices[index];
          int sellfurther = helper(index+1,prices, 0,dp);
           sellprofit= Math.max(sellhere,sellfurther);
        }
        return dp[index][buy]=Math.max(buyprofit,sellprofit);
    }
}

03.TABULATION - BOTTOM UP 

  class Solution {
    public int maxProfit(int[] prices)
    {
         int dp[][]= new int [prices.length+2][2];
        int n=prices.length;
  
        for(int i=n-1;i>=0;i--){
         for(int j=0;j<=1;j++){
           
         
           if(j==0)//BUY 
           {
            int take = dp[i+1][1] - prices[i];
            int nottake =dp[i+1][0] ;
            dp[i][j] = Math.max(take,nottake);
           }
           else //SELL
           {
           int sellhere =dp[i+2][0] + prices[i];
           int sellfurther = dp[i+1][1];
           dp[i][j]=Math.max(sellhere,sellfurther);
           }
         }

        }
        
        return dp[0][0];
    }
}

04.SPACE OPTIMIZATION - To 3 1D Array

  class Solution {
    public int maxProfit(int[] prices)
    {
         int dp1[]= new int [2];
         int dp2[]=new int[2];
        int n=prices.length;
  
        for(int i=n-1;i>=0;i--){
        int temp[] = new int [2];
         for(int j=0;j<=1;j++){
           
         
           if(j==0)//BUY 
           {
            int take = dp1[1] - prices[i];
            int nottake =dp1[0] ;
            temp[j] = Math.max(take,nottake);
           }
           else //SELL
           {
           int sellhere =dp2[0] + prices[i];
           int sellfurther = dp1[1];
           temp[j]=Math.max(sellhere,sellfurther);
           }

          
         }
        
         dp2=dp1;
         dp1=temp;

        }
        
        return dp1[0];
    }
}


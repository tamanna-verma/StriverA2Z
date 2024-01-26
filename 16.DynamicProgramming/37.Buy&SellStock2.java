//1.RECURSION

class Solution {
    public int maxProfit(int[] prices)
    {
        return helper(0,prices, true);
    }

    public int helper(int index ,int[] prices , Boolean buy){
        if(index==prices.length)return 0;

         
        int buyprofit = 0;
        int sellprofit = 0;
        if(buy)
        {
         int take = helper(index+1 , prices , false) - prices[index] ;
         int nottake = helper(index+1, prices , true);
         buyprofit = Math.max(take,nottake);
        }
        else
        {
          int sellhere = helper(index+1 , prices ,true) + prices[index];
          int sellfurther = helper(index+1,prices, false);
           sellprofit= Math.max(sellhere,sellfurther);
        }
        return Math.max(buyprofit,sellprofit);
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
         if(index==prices.length)return 0;

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
          int sellhere = helper(index+1 , prices ,1,dp) + prices[index];
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
        int dp[][]= new int [prices.length+1][2];
        int n=prices.length;
  
        for(int i=n-1;i>=0;i--){
         for(int j=0;j<=1;j++){
           
         
           if(j==1)
           {
            int take = dp[i+1][0] - prices[i];
            int nottake =dp[i+1][1] ;
            dp[i][j] = Math.max(take,nottake);
           }
           else
           {
           int sellhere =dp[i+1][1] + prices[i];
           int sellfurther = dp[i+1][0];
           dp[i][j]=Math.max(sellhere,sellfurther);
           }
         }

        }
        
        return dp[0][1];
    }
}


04.SPACE OPTIMIZATION 

  class Solution {
    public int maxProfit(int[] prices)
    {
        int dp[]= new int [2];
       
        int n=prices.length;
  
        for(int i=n-1;i>=0;i--){
         int temp[]= new int[2];
         for(int j=0;j<=1;j++){
   
           if(j==1)
           {
            int take = dp[0] - prices[i];
            int nottake =dp[1] ;
           temp[j] = Math.max(take,nottake);
           }
           else
           {
           int sellhere =dp[1] + prices[i];
           int sellfurther = dp[0];
           temp[j]=Math.max(sellhere,sellfurther);
           }
         }
         dp=temp;

        }
        
        return dp[1];
    }
}

05.SPACE OPTIMIZATION - 2 VARIABLES 

  class Solution {
    public int maxProfit(int[] prices)
    {
        int aheaddontbuy0= 0;
        int aheadbuy =0;
        int n=prices.length;
  
        for(int i=n-1;i>=0;i--){
         int currentdontbuy=0;
         int currentbuy=0;
         for(int j=0;j<=1;j++){
   
           if(j==1)
           {
            int take = aheaddontbuy0 - prices[i];
            int nottake = aheadbuy;
           currentbuy= Math.max(take,nottake);
           }
           else
           {
           int sellhere =aheadbuy + prices[i];
           int sellfurther = aheaddontbuy0;
           currentdontbuy=Math.max(sellhere,sellfurther);
           }
         }
        aheaddontbuy0=currentdontbuy;
        aheadbuy=currentbuy;

        }
        
        return aheadbuy;
    }
}

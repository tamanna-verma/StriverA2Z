01.RECURSION 

  class Solution {
    public int maxProfit(int[] prices, int fee) {
        return helper(0,prices , true, fee);
    }
     public int helper(int index ,int[] prices , Boolean buy, int fee){
        if(index==prices.length)return 0;

         
        int buyprofit = 0;
        int sellprofit = 0;
        if(buy)
        {
         int take = helper(index+1 , prices , false, fee) - prices[index] ;
         int nottake = helper(index+1, prices , true,fee);
         buyprofit = Math.max(take,nottake);
        }
        else
        {
          int sellhere = helper(index+1 , prices ,true,fee) + prices[index] -fee;
          int sellfurther = helper(index+1,prices, false,fee);
           sellprofit= Math.max(sellhere,sellfurther);
        }
        return Math.max(buyprofit,sellprofit);
    }
}

02.MEMOIZATION-TOP DOWN 
  class Solution {
    public int maxProfit(int[] prices, int fee) {
         int dp[][]= new int [prices.length][2];
        for(int i=0;i<prices.length;i++){Arrays.fill(dp[i],-1);}
        return helper(0,prices, 1,dp,fee);
    }
     public int helper(int index ,int[] prices , int buy,int[][]dp, int fee){
        if(index==prices.length)return 0;

        if(dp[index][buy]!=-1)return dp[index][buy];
       
         
        int buyprofit = 0;
        int sellprofit = 0;
        if(buy==1)
        {
         int take = helper(index+1 , prices , 0,dp,fee) - prices[index] ;
         int nottake = helper(index+1, prices , 1,dp,fee);
         buyprofit = Math.max(take,nottake);
        }
        else
        {
          int sellhere = helper(index+1 , prices ,1,dp,fee) + prices[index]-fee;
          int sellfurther = helper(index+1,prices, 0,dp,fee);
           sellprofit= Math.max(sellhere,sellfurther);
        }
        return dp[index][buy]=Math.max(buyprofit,sellprofit);
    }
}
03.TABULATION 

  class Solution {
    public int maxProfit(int[] prices, int fee) {
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
           int sellhere =dp[i+1][1] + prices[i]-fee;
           int sellfurther = dp[i+1][0];
           dp[i][j]=Math.max(sellhere,sellfurther);
           }
         }

        }
        
        return dp[0][1];
    }
}

04.SPACE OPTIMIZATION  - TO 2 1-D ARRAY 

  class Solution {
    public int maxProfit(int[] prices, int fee) {
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
           int sellhere =dp[1] + prices[i]-fee;
           int sellfurther = dp[0];
           temp[j]=Math.max(sellhere,sellfurther);
           }
         }
         dp=temp;

        }
        
        return dp[1];
    }
}

05.SPACE OPTIMIZATION - TO 4 VARIABLES

  class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dpaheadbuy= 0;
        int dpaheaddontbuy=0;

       
        int n=prices.length;
  
        for(int i=n-1;i>=0;i--){

         int currentbuy=0;
         int currentdontbuy=0;
         for(int j=0;j<=1;j++){
   
           if(j==1)//buy
           {
            int take = dpaheaddontbuy - prices[i];
            int nottake =dpaheadbuy ;
           currentbuy = Math.max(take,nottake);
           }
           else //sell
           {
           int sellhere =dpaheadbuy + prices[i]-fee;
           int sellfurther = dpaheaddontbuy;
           currentdontbuy=Math.max(sellhere,sellfurther);
           }
         }
        dpaheaddontbuy=currentdontbuy;
        dpaheadbuy = currentbuy;

        }
        
        return dpaheadbuy;
    }
}

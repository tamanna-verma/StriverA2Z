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
03.TABULATION

  

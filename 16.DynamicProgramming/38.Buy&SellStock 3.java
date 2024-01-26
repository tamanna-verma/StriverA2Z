01.Recursion
  class Solution {
    public int maxProfit(int[] prices) {
        
        int ans = helper(0,prices , true , 2);
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

02.MEMOIZATION - TOP DOWN -3-D DP

  class Solution {
    public int maxProfit(int[] prices) {
        int dp[][][]= new int [prices.length][2][3];
        for(int i=0;i<prices.length;i++)
        {
            for(int j=0;j<=1;j++)
            {
                Arrays.fill(dp[i][j],-1);
            }
        }
        int ans = helper(0,prices , 1 ,2, dp);
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

03.TABULATION - BOTTOM UP - 3-D DP
  class Solution {
    public int maxProfit(int[] prices) {
        int dp[][][]= new int [prices.length+1][2][3];
        for(int j=0;j<=1;j++){
            for(int k=0;k<=2;k++){
                dp[prices.length][j][k]=0;
            }
        }
        for(int i=0;i<prices.length;i++)
        {
            for(int j=0;j<=1;j++)
            {
                dp[i][j][0]=0;
            }
        }

        for(int i=prices.length-1;i>=0;i--){
            for(int j = 0;j<=1;j++){
              for(int k =1;k<=2;k++){
                  int buyprofit = 0;
                 int sellprofit = 0;
                 if(j==1)
                 {
                int take = dp[i+1][0][k] - prices[i] ;
                int nottake = dp[i+1][1][k];
                dp[i][j][k]= Math.max(take,nottake);
                 }          
            else {
                int sellhere = dp[i+1][1][k-1] + prices[i];//sell krne k bad next buy se phle cap -- krte h 
                int sellfurther =dp[i+1][0][k];
                dp[i][j][k]= Math.max(sellhere,sellfurther);
                }

                 }
                  
              }
            }
            return dp[0][1][2];
        }
    }


04.SPACE OPTIMIZED - 2D DP

  class Solution {
    public int maxProfit(int[] prices) {
        int dp[][]= new int[2][3];
        for(int j=0;j<=1;j++){
            for(int k=0;k<=2;k++){
                dp[j][k]=0;
            }
        }
       
            for(int j=0;j<=1;j++)
            {
                dp[j][0]=0;
            }
        

        for(int i=prices.length-1;i>=0;i--){
              int temp[][]= new int[2][3];
            for(int j = 0;j<=1;j++){
              for(int k =1;k<=2;k++){
                  int buyprofit = 0;
                 int sellprofit = 0;
                 if(j==1)
                 {
                int take = dp[0][k] - prices[i] ;
                int nottake = dp[1][k];
                temp[j][k]= Math.max(take,nottake);
                 }          
            else {
                int sellhere = dp[1][k-1] + prices[i];//sell krne k bad next buy se phle cap -- krte h 
                int sellfurther =dp[0][k];
                temp[j][k]= Math.max(sellhere,sellfurther);
                }

                 }
                  
              }
              dp=temp;
            }
            return dp[1][2];
        }
    }

05.SPACE OPTIMIZATION 1 d array //NEXT OPTIMIZATION IS FOR 2*4 = PENDING
  

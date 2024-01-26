class Solution {
    public int maxProfit(int[] prices)
    {
        int n=prices.length;
        int min=Integer.MAX_VALUE;
        int profit =0;
        for(int i=0;i<n;i++){
               profit=Math.max(profit,prices[i]-min);
               if(prices[i]<min)min=prices[i];
        }
        return profit;
        
    }
}

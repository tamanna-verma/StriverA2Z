//01.Recursion 

// this question is for unbounded knapsack 
// it means there is infinite supply 

class Solution {
    public int coinChange(int[] coins, int amount)
    {
        int n=coins.length;
        int index=n-1;
       int ans= helper(index , coins , amount);
        if(ans>=(int)1e9)return -1;
        else return ans;
    }
    public int helper(int index , int coins[] , int target){
        if(target==0)return 0;
        if(index==0 )
        {
         if(target % coins[index]==0)return target / coins[index];
         else return (int)1e9;
         
        } 
       
         int take = (int)1e9;
         if(coins[index]<=target) take= 1+helper(index , coins , target-coins[index]);
        //   take+=1;

         int nottake= (int)1e9;
          nottake= helper(index-1 , coins , target);
          
          return Math.min(take , nottake);

        }
      
    }


02.MEMOIZATION - TOP DOWN 

  // this question is for unbounded knapsack 
// it means there is infinite supply 

class Solution {
    public int coinChange(int[] coins, int amount)
    {
        int n=coins.length;
        int index=n-1;
        int dp[][]= new int [n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
       int ans= helper(index , coins , amount , dp);
        if(ans>=(int)1e9)return -1;
        else return ans;
    }
    public int helper(int index , int coins[] , int target , int[][]dp){
        if(target==0)return 0;
        if(index==0 )
        {
         if(target % coins[index]==0)return target / coins[index];
         else return (int)1e9;
        } 

        if(dp[index][target]!=-1)return dp[index][target];
       
         int take = (int)1e9;
         if(coins[index]<=target) take= 1+helper(index , coins , target-coins[index] , dp);
        //   take+=1;

         int nottake= (int)1e9;
          nottake= helper(index-1 , coins , target, dp);
          
          return dp[index][target]= Math.min(take , nottake);

        }
      
    }


03.TABULATION - BOTTOM UP 

  class Solution {
    public int coinChange(int[] coins, int amount) {
       if(amount<=0)return 0;
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
          for(int i=0;i<n;i++){
              Arrays.fill(dp[i],(int)1e9);
          }
       
          for(int j=coins[0];j<amount+1 ;j++){
              if((j%coins[0])==0)dp[0][j]=j/coins[0];
          }
       for(int i=1;i<n;i++){
           dp[i-1][0]=0;
           for(int j=0;j<amount+1 ; j++){
             
                int take=(int)1e9;
                if(coins[i]<=j){
                    take=1+dp[i][j-coins[i]];
                }
                int nottake =  dp[i-1][j];
                 
                 dp[i][j]=Math.min(take , nottake);              
           }
       }
        return dp[n-1][amount]>=(int )(1e9)?-1:dp[n-1][amount];
    }

}


04.SPACE OPTIMIZATION 

  class Solution {
    public int coinChange(int[] coins, int amount) {
       if(amount<=0)return 0;
        int n = coins.length;
        int dp[] = new int[amount + 1];
       
              Arrays.fill(dp,(int)1e9);

   if(coins[0]<amount+1){
          for(int j=coins[0];j<amount+1 ;j++){
              if((j%coins[0])==0)
              {
                dp[j]=j/coins[0];
              }
          }
   }
      

dp[0]=0;
   
       for(int i=1;i<n;i++){
        int []temp = new int [amount+1];        
           for(int j=0;j<amount+1 ; j++){
             
              int nottake =  dp[j];
                int take=(int)1e9;
               
               if(coins[i]<=j){
                    take=1+temp[j-coins[i]];
                }
               
                 
               temp[j]=Math.min(take , nottake);              
           }
          
           dp=temp;
        //    dp[0]=0;
          
       }
        return dp[amount]>=(int )(1e9)?-1:dp[amount];
    }

}

05. BEST SPACE OPTIMISATION - Single Array used 
  
  
  class Solution {
    public int coinChange(int[] coins, int amount) {
       if(amount<=0)return 0;
        int n = coins.length;
        int dp[] = new int[amount + 1];
       
              Arrays.fill(dp,(int)1e9);

 
          for(int j=0;j<amount+1 ;j++){
              if((j%coins[0])==0)
              {
                dp[j]=j/coins[0];
              }
          }
         for(int i=1;i<n;i++){ 

           for(int j=coins[i];j<=amount;j++){ // we are starting from coins[i] because we wont be able to take it if target is only less than coin value

           //and we are starting from start till end , because we need the previous values here 

                int nottake =  dp[j];
                int take=(int)1e9;  
                 int val=j;
                if(coins[i]<=val){
                    take=1+dp[val-=coins[i]];
                }  
               dp[j]=Math.min(take , nottake);              
           }  
        //     for(int k=0;k<=amount;k++){
        //     System.out.print(dp[k] +" ");
        //   }
        //   System.out.println();
       }
        return dp[amount]>=(int )(1e9)?-1:dp[amount];
    }

}


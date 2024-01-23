01.RECURSION 


class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int index = n - 1;
        int ans = helper(index, coins, amount);
        return ans;
    }

    public int helper(int index, int coins[], int target) {
        if (target == 0)
            return 1;
        if (index == 0) {
            if (target % coins[index] == 0)
                return 1;
            else
                return 0;

        }
        int take = 0;
        if (coins[index] <= target)
            take = helper(index, coins, target - coins[index]);

        int nottake = 0;
        nottake = helper(index - 1, coins, target);

        return take + nottake;

    }

}

02.MEMOIZATION-TOP DOWN 

  
class Solution {
 public int change(int amount, int[] coins) 
{
    int n=coins.length;
    int index=n-1;
    int dp[][]= new int [n][amount+1];
    for(int i=0;i<n;i++)
    {
    Arrays.fill(dp[i],-1);
    }
    int ans= helper(index , coins , amount , dp);
    return ans;
}

    public int helper(int index, int coins[], int target, int[][] dp) {
        if (target == 0)
            return 1;
        if (index == 0) {
            if (target % coins[index] == 0)
                return 1;
            else
                return 0;
        }

        if (dp[index][target] != -1)
            return dp[index][target];

        int take = 0;
        if (coins[index] <= target)
            take = helper(index, coins, target - coins[index],dp);
        int nottake = 0;
          nottake = helper(index - 1, coins, target, dp);

        return dp[index][target] = take+ nottake;

    }
 }

03.TABULATION -BOTTOM UP 

  
class Solution {
    public int change(int amount, int[] coins) {
     
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
         dp[0][0]=1;
        if(coins[0]==0)dp[0][0]=2;
       
        for (int j = coins[0]; j < amount + 1; j++) {
            if ((j % coins[0]) == 0)dp[0][j] =1;
        }
        for (int i = 1; i < n; i++) {
        
            for (int j = 0; j < amount + 1; j++) {

                int take = 0;
                if (coins[i] <= j) {
                    take = dp[i][j - coins[i]];
                }
                int nottake = dp[i - 1][j];

                dp[i][j] = take+ nottake;
            }
        }
        return dp[n - 1][amount] ;
    }

}

04.SPACE OPTIMIZATION - 2 ARRAY 
  
class Solution {
    public int change(int amount, int[] coins) {
      
        int n = coins.length;
        int dp[] = new int[amount + 1];

        if (coins[0] < amount + 1) {
            for (int j = coins[0]; j < amount + 1; j++) {
                if ((j % coins[0]) == 0) {
                    dp[j] = 1;
                }
            }
        }
        if(coins[0]==0)dp[0] = 2;
        else dp[0]=1;
        for (int i = 1; i < n; i++) {
            int[] temp = new int[amount + 1];
            for (int j = 0; j < amount + 1; j++) {

                int nottake = dp[j];
                int take = 0;

                if (coins[i] <= j) {
                    take =  temp[j - coins[i]];
                }
                temp[j] = take+ nottake;
            }
            dp = temp;
        }
        return dp[amount];
    }

}

05.SPACE OPTIMIZATION - 1 ARRAY 

  
class Solution {
    public int change(int amount, int[] coins) {
    int n = coins.length;
    int dp[] = new int[amount + 1];
   
   for(int j=0;j<amount+1 ;j++){
    if((j%coins[0])==0)
      {
       dp[j]=1;
      }
    }
    if(coins[0]==0)dp[0]=2;

    for(int i=1;i<n;i++){
    for(int j=0;j<=amount;j++)
    {
    int nottake = dp[j];
    int take=0;
     if(coins[i]<=j) take=dp[j-coins[i]]; 
    dp[j]=take + nottake;
    }   
    }
    return dp[amount];
    }

}

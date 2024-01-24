01.Recursion

  class Solution 
{
    public int longestCommonSubsequence(String text1, String text2) 
    {
        int ans = 0;
        ans = helper(text1.length()-1, text2.length()-1 , text1, text2);
        return ans;
    }

    public static int helper( int index1 ,int index2 , String s1 , String s2){
        if(index1<0 || index2 <0)return 0;

        int same= 0;
        if(s1.charAt(index1)==s2.charAt(index2))
        same = 1+ helper(index1-1,index2-1,s1,s2);

        int left = helper(index1 , index2-1 , s1 ,s2) ;
        int right = helper(index1-1 , index2 , s1,s2);
        return Math.max(Math.max(left,right) ,same);
        
    }
}
02.MEMOIZATION - TOP DOWN 

class Solution 
{
    public int longestCommonSubsequence(String text1, String text2) 
    {
        int ans = 0;
        int n1=text1.length();
        int n2= text2.length();
        int [][] dp= new int [n1][n2];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        ans = helper(n1-1, n2-1 , text1, text2, dp);
        return ans;
    }

    public static int helper( int index1 ,int index2 , String s1 , String s2, int [][]dp){
        if(index1<0 || index2 <0)return 0;
        if(dp[index1][index2]!=-1)return dp[index1][index2];

        int same= 0;
        if(s1.charAt(index1)==s2.charAt(index2))
        same = 1+ helper(index1-1,index2-1,s1,s2,dp);

        int left = helper(index1 , index2-1 , s1 ,s2,dp) ;
        int right = helper(index1-1 , index2 , s1,s2,dp);
        return dp[index1][index2]=Math.max(Math.max(left,right) ,same);
        
    }
}

03.TABULATION - BOTTOM UP 

  class Solution 
{
    public int longestCommonSubsequence(String text1, String text2) 
    {
        int ans = 0;
        int n1=text1.length();
        int n2= text2.length();
        int [][] dp= new int [n1+1][n2+1];
        //HERE BASE CASE IS IF INDEX IS LESS THAN 0 THEN RETURN 0 
        // SO WE CAN SIMPLY DO RIGHT SHIFT 
         
         for(int i=1;i<n1+1;i++){
             for(int j=1;j<n2+1; j++){

                 int take=0;
                 if(text1.charAt(i-1)==text2.charAt(j-1)) take = 1+ dp[i-1][j-1];
                 int left=dp[i-1][j];
                 int right = dp[i][j-1];

                 int nottake = Math.max(left,right);

                  dp[i][j]=Math.max(take,nottake);
             }
         }
         return dp[n1][n2];
    }

 
}

04.SPACE OPTIMIZATION - 2 ARRAYS 

  class Solution 
{
    public int longestCommonSubsequence(String text1, String text2) 
    {
        int ans = 0;
        int n1=text1.length();
        int n2= text2.length();
        int [] dp= new int [n2+1];
        //HERE BASE CASE IS IF INDEX IS LESS THAN 0 THEN RETURN 0 
        // SO WE CAN SIMPLY DO RIGHT SHIFT 
         
         for(int i=1;i<n1+1;i++){
             int temp[]= new int [n2+1];
             for(int j=1;j<n2+1; j++){

                 int take=0;
                 if(text1.charAt(i-1)==text2.charAt(j-1)) take = 1+ dp[j-1];//cant do in 1 array kyuki it need current row dp[j-1] also and 
               //temp[j-1] also 
                 int left=dp[j];
                 int right = temp[j-1];

                 int nottake = Math.max(left,right);

                  temp[j]=Math.max(take,nottake);
             }
             dp=temp;
         }
         return dp[n2];
    }

 
}

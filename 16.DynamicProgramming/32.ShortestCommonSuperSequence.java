01.TABULATION

  class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        //we will be getting the sum of lengths of both the strings and reducing the value of lcs 
        // and that will be the length of supersequence

        // but to get the supersequence/ print the supersequence , we will needing the tabulation 
        // dp table 

        int n1= str1.length();
        int n2= str2.length();
        int [][] dp = new int [n1+1][n2+1];

        for(int i=1;i<n1+1;i++){
            for(int j=1;j<n2+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1))dp[i][j]=1 + dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        //so now we have the dp array ready 
        String ans="";
        int i=n1;
        int j=n2;
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
              ans+=str1.charAt(i-1);
              i--;
              j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                ans+=str1.charAt(i-1);
                i--;
            }
            else {
                ans+=str2.charAt(j-1);
                j--;
            }
        }

        if(i>0){
            while(i>0){
                ans+=str1.charAt(i-1);
                i--;
            }
        }
        if(j>0){
            while(j>0){
              ans+=str2.charAt(j-1);
                j--;
            }
        }

StringBuilder temp= new StringBuilder(ans).reverse();
       return temp.toString();
    }
}
  

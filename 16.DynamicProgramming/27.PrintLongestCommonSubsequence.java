public class Solution {
    public static String findLCS(int n, int m, String s1, String s2){
      // first of all we will find the length of the longest common subsequence 

      int [][]dp = new int[n+1][m+1];

      for(int i=1;i<n+1;i++){
          for(int j=1;j<m+1;j++){

              int take =0;
              if(s1.charAt(i-1)==s2.charAt(i-1))take=1 + dp[i-1][j-1];

              int leftsame=dp[i-1][j];
              int rightsame = dp[i][j-1];

             int nottake=Math.max(leftsame,rightsame);
            
            dp[i][j]=Math.max(take , nottake);
          }
      }
      //so now we have the length of longest common subsequence
       int length = dp[n][m];
      StringBuilder str = new StringBuilder("");
      for(int i=0;i<length;i++)
      {
          str.append("$");
       }

      //so we have created a summy ans string 
 int i=n;int j=m;
            while(i>0&&j>0)
               {

              if(s1.charAt(i)==s2.charAt(j))
              {
                  str.setCharAt(length-1,s1.charAt(i));
                  length--;
                  i--;
                  j--;

              }
              else
              {
                int upper= dp[i-1][j];
                int left = dp[i][j-1];

                if(upper>left)
                {
                  i--;
                }
                else
                {
                    j--;
                }

              }
          
        }
        return str.toString();
    }
}

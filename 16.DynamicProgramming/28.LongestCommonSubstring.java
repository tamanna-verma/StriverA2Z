01.Tabulation 

  public class Solution {
    public static int lcs(String str1, String str2){
      //substring hai to it has to be consecutive , 
      //if till last [i-1][j-1]was greater than 0
      //then only that will be carried till next index 
      int n=str1.length();
      int m=str2.length();
      int[][]dp = new int [n][m];
       int max=0;
      for(int i=0;i<m;i++)
      {
          if(str1.charAt(0)==str2.charAt(i))
          {
              dp[0][i]=1;
              max=Math.max(max , 1);
          }
      }
     
      for(int i=1;i<n;i++){
          for(int j=0;j<m;j++){
                
                
             if(str1.charAt(i)==str2.charAt(j))
             {
                 if(j==0)dp[i][j] =1;
                 else dp[i][j] =dp[i-1][j-1] +1;
             }
            
             max=Math.max(max , dp[i][j]);
          }
      }
      return max;
      
    }
}
//USING RIGHT SHIFTING INDEXES FOR DP ARRAY - FOR EASY INDEX<0 BASE CASE - > INDEX I IS TREATED AS I+1
public class Solution {
    public static int lcs(String str1, String str2){
      
      int n=str1.length();
      int m=str2.length();
      int[][]dp = new int[n+1][m+1];
       int max=0;
      for(int i=1;i<=n;i++){
          for(int j=1;j<=m;j++){
            if(str1.charAt(i-1)==str2.charAt(j-1))
             {
                  dp[i][j] =dp[i-1][j-1] +1;
             }
             max=Math.max(max , dp[i][j]);
          }
      }
      return max;
      
    }
}


02.SPACE OPTIMIZATION - USING 2 ARRAY
  
  public class Solution {
    public static int lcs(String str1, String str2){
      //substring hai to it has to be consecutive , 
      //if till last [i-1][j-1]was greater than 0
      //then only that will be carried till next index 
      int n=str1.length();
      int m=str2.length();
      int[]dp = new int[m+1];
       int max=0;
     
     
      for(int i=1;i<=n;i++){
          int temp[]= new int [m+1];
          for(int j=1;j<=m;j++){
                
                
             if(str1.charAt(i-1)==str2.charAt(j-1))
             {
                 
                temp[j] =dp[j-1] +1;
             }
            
             max=Math.max(max , temp[j]);
          }
          dp=temp;
      }
      return max;
      
    }
}
03.SPACE OPTIMIZATION - USING 1 ARRAY
  public class Solution {
    public static int lcs(String str1, String str2){
      int n=str1.length();
      int m=str2.length();
      int[]dp = new int[m+1];
       int max=0;   
      for(int i=1;i<=n;i++){       
          for(int j=m;j>=1;j--){   
             if(str1.charAt(i-1)==str2.charAt(j-1))
             {              
                dp[j] =dp[j-1] +1;
             } else dp [j]=0;          
             max=Math.max(max , dp[j]);
          }       
      }
      return max;
      
    }
}


  

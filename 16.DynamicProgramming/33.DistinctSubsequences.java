01.RECURSION 
  class Solution {
    public int numDistinct(String s, String t) {
        int ans= helper(s.length()-1,t.length()-1,s ,t);
        return ans;
    }
    public static int helper( int index1 , int index2 , String s1 , String s2){     
        if(index2<0)return 1;
        if(index1<0)return 0;      
       int take = 0;
       if(s1.charAt(index1)==s2.charAt(index2))
       {
           take = helper(index1-1, index2-1 , s1 , s2);
       }
       int nottake = helper(index1-1 , index2 , s1 , s2);
       return take+nottake;       
    }
}
02.MEMOIZATION- TOP DOWN 

  class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m =t.length();
        int dp[][]= new int [n][m];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
        int ans= helper(n-1,m-1,s ,t, dp);
        return ans;
    }
    public static int helper( int index1 , int index2 , String s1 , String s2 , int [][]dp){     
        if(index2<0)return 1;
        if(index1<0)return 0;  
        if(dp[index1][index2]!=-1)return dp[index1][index2];    
       int take = 0;
       if(s1.charAt(index1)==s2.charAt(index2))
       {
           take = helper(index1-1, index2-1 , s1 , s2, dp);
       }
       int nottake = helper(index1-1 , index2 , s1 , s2 , dp);
       return  dp[index1][index2] =take+nottake;       
    }
}
03.TABULATION 

  class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m =t.length();
        int dp[][]= new int [n+1][m+1];
        
        for(int i=0;i<n;i++){
         dp[i][0]=1;
        }

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                int take =0;
                if(s.charAt(i-1)==t.charAt(j-1))take=dp[i-1][j-1];
                int nottake = dp[i-1][j];
                dp[i][j]=take+nottake;
            }
        }    
       return  dp[n][m];       
    }
}

04.SPACE OPTIMIZATION 

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m =t.length();
        int dp[]= new int [m+1];
        int temp[]=new int [m+1];

        for(int i=1;i<=n;i++)
        {   
            temp=new int[m+1];
            dp[0]=1;
            for(int j=1;j<=m;j++)
            {
                int take =0;
                if(s.charAt(i-1)==t.charAt(j-1))take=dp[j-1];
                int nottake = dp[j];
                temp[j]=take+nottake;
            }
            dp=temp;     
        }    
       return  dp[m];       
    }
}

05.SPACE OPTIMIZATION - TO 1 ARRAY SPACE 

  class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m =t.length();
        int dp[]= new int [m+1];

        for(int i=1;i<=n;i++)
        {   
          dp[0]=1;
            for(int j=m;j>=1;j--)
            {
                int take =0;
                if(s.charAt(i-1)==t.charAt(j-1))take=dp[j-1];
                int nottake = dp[j];
                dp[j]=take+nottake;
            }
          
        }    
       return  dp[m];       
    }
}

01.RECURSION

  class Solution {
    public int minDistance(String word1, String word2) {
       // we need to convert string 1 to string 2 
       // we need to count the minimum efforts 
       int n1=word1.length();
       int n2=word2.length();
      int ans = helper(n1-1, n2-1 , word1 , word2);
      return ans;
    }
    public int helper( int index1 , int index2 , String word1 , String word2){
        if(index2<0)return index1+1;   
        if(index1<0)return index2+1;
        
                  
                            
                if(word1.charAt(index1)==word2.charAt(index2))return helper(index1-1 , index2-1 , word1 , word2);

                int insert =1+helper(index1 ,index2-1 , word1 , word2);
                int replace =1+helper(index1- 1, index2 -1 , word1 , word2);
                int delete =1+helper(index1-1 , index2 , word1 , word2);

                int min=Math.min(insert,Math.min(delete,replace));
            return min;
        

    }
}
02.MEMOIZATION 

  class Solution {
    public int minDistance(String word1, String word2) {
       // we need to convert string 1 to string 2 
       // we need to count the minimum efforts 
       int n1=word1.length();
       int n2=word2.length();
       
       int [][]dp = new int [n1][n2];
       for(int i=0;i<n1;i++)Arrays.fill(dp[i],-1);
      int ans = helper(n1-1, n2-1 , word1 , word2,dp);
      return ans;
    }
    public int helper( int index1 , int index2 , String word1 , String word2, int [][]dp){
        if(index2<0)return index1+1;   
        if(index1<0)return index2+1;
        
        if(dp[index1][index2]!=-1)return dp[index1][index2];        
                if(word1.charAt(index1)==word2.charAt(index2))return helper(index1-1 , index2-1 , word1 , word2,dp);

                int insert =1+helper(index1 ,index2-1 , word1 , word2,dp);
                int replace =1+helper(index1- 1, index2 -1 , word1 , word2,dp);
                int delete =1+helper(index1-1 , index2 , word1 , word2,dp);

                int min=Math.min(insert,Math.min(delete,replace));
            return dp[index1][index2] = min;
        

    }
}


03.TABULATION - BOTTOM UP

  class Solution {
    public int minDistance(String word1, String word2) {
       // we need to convert string 1 to string 2 
       // we need to count the minimum efforts 
       int n1=word1.length();
       int n2=word2.length();
       
       int [][]dp = new int [n1+1][n2+1];
       for(int i=0;i<=n1;i++){
          dp[i][0]=i;
       }
       for(int j=0;j<=n2;j++)
       {
         dp[0][j]=j;
       }
         
         for(int i=1;i<=n1;i++)
           {
           for(int j=1;j<=n2;j++)
            {   
            if(word1.charAt(i-1)==word2.charAt(j-1))dp[i][j]=dp[i-1][j-1];
             else{
                int insert =1+dp[i][j-1] ;
                int replace =1+dp[i-1][j-1];
                int delete =1+dp[i-1][j];
               
                int min=Math.min(insert,Math.min(delete,replace));
                dp[i][j] = min;
             }
           }
    }
    return dp[n1][n2];
    }
}

04.SPACE OPTIMIZATION - 2 1-D Array

  class Solution {
    public int minDistance(String word1, String word2) {
       // we need to convert string 1 to string 2 
       // we need to count the minimum efforts 
       int n1=word1.length();
       int n2=word2.length();
       
       int []dp = new int [n2+1];
       for(int j=0;j<=n2;j++){
          dp[j]=j;
       }
 
         for(int i=1;i<=n1;i++)
           {
            int temp[]=new int[n2+1];
            temp[0]=i;
           for(int j=1;j<=n2;j++)
            {   
            if(word1.charAt(i-1)==word2.charAt(j-1))temp[j]=dp[j-1];
             else{
                int insert =1+temp[j-1] ;
                int replace =1+dp[j-1];
                int delete =1+dp[j];
               
                int min=Math.min(insert,Math.min(delete,replace));
                temp[j] = min;
             }
           }
           dp=temp;
    }
    return dp[n2];
    }
}

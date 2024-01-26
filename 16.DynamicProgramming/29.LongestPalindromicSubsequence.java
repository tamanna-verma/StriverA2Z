01.Recursion 

  class Solution {
    public int longestPalindromeSubseq(String first) {

     // in order to get the longest palindromic subsequence 
     //first of all , we will be reversing the string s and then find the lcs

        StringBuilder str = new StringBuilder(first);
        str.reverse();
        String second = str.toString();

        //now in these 2 , we need to find longest common subsequence 
        return helper(first.length()-1 , second.length()-1 , first , second);

    }
    public int helper(int index1 , int index2 , String first , String second){
     if(index1<0 || index2<0)return 0;

      int same = 0;
      if(first.charAt(index1)==second.charAt(index2))same = 1 + helper(index1-1,index2-1,first , second);

     
      int left = helper(index1-1, index2 , first , second);
      int right = helper(index1 , index2-1 , first , second);

     int notsame= Math.max(left , right);

     int max = Math.max(same , notsame);
     return max;
    }
}

02.Memoization - Top Down 

  class Solution {
    public int longestPalindromeSubseq(String first) {

     // in order to get the longest palindromic subsequence 
     //first of all , we will be reversing the string s and then find the lcs

        StringBuilder str = new StringBuilder(first);
        str.reverse();
        String second = str.toString();
        int n = first.length();
        
        int [][]dp= new int [n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        //now in these 2 , we need to find longest common subsequence 
        return helper(first.length()-1 , second.length()-1 , first , second, dp);

    }
public int helper(int index1 , int index2 , String first , String second , int [][] dp ){
     if(index1<0 || index2<0)return 0;
        
        if(dp[index1][index2] != -1)return dp[index1][index2];
      int same = 0;
      if(first.charAt(index1)==second.charAt(index2))same = 1 + helper(index1-1,index2-1,first , second,dp);

     
      int left = helper(index1-1, index2 , first , second,dp);
      int right = helper(index1 , index2-1 , first , second,dp);

     int notsame= Math.max(left , right);

     int max = Math.max(same , notsame);
     return dp[index1][index2]=max;
    }
}

03.Tabulation 

  class Solution {
    public int longestPalindromeSubseq(String first) {

     // in order to get the longest palindromic subsequence 
     //first of all , we will be reversing the string s and then find the lcs

        StringBuilder str = new StringBuilder(first);
        str.reverse();
        String second = str.toString();
        int n = first.length();
        
        int [][]dp= new int [n+1][n+1];
       
        //now in these 2 , we need to find longest common subsequence 
        return helper(n , n , first , second, dp);

    }
public int helper(int index1 , int index2 , String first , String second , int [][] dp ){
   // agar i ya j 0 hai to it will return 0 // base case
   // otherwise we will be checking if the character at the index1 and index2 is same , if not same , 
   //then once we will deduct index 1 and then we will deduct index 2
  
       for(int i=1;i<=index1;i++){
           for(int j=1;j<=index2;j++){
                
                int same=0;
                int notsame =0;
                if(first.charAt(i-1)==second.charAt(j-1))same=1+dp[i-1][j-1];
               
                int left = dp[i-1][j];
                int right = dp[i][j-1];
                notsame= Math.max(left , right);    

                int max= Math.max(same , notsame);
                dp[i][j]=max;
           }
       }
       return dp[index1][index2];
     
    }
}

04.SPACE OPTIMIZATION 

  class Solution {
    public int longestPalindromeSubseq(String first) {

     // in order to get the longest palindromic subsequence 
     //first of all , we will be reversing the string s and then find the lcs

        StringBuilder str = new StringBuilder(first);
        str.reverse();
        String second = str.toString();
        int n = first.length();
        int []dp= new int [n+1];
          int temp[]=new int [n+1];
       
        //now in these 2 , we need to find longest common subsequence 
        return helper(n , n , first , second, dp);

    }
public int helper(int index1 , int index2 , String first , String second , int [] dp ){
       for(int i=1;i<=index1;i++){
         int temp = new int [dp.length+1];
           for(int j=1;j<=index2;j++){
                
                int same=0;
                int notsame =0;
                if(first.charAt(i-1)==second.charAt(j-1))same=1+dp[j-1];
               
                int left = dp[j];
                int right = temp[j-1];
                notsame= Math.max(left , right);    

                int max= Math.max(same , notsame);
                temp[j]=max;
           }
           dp=temp;
       }
       return dp[index2];
     
    }
}



  

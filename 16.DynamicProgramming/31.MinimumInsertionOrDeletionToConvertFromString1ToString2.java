//first of all , we will be getting the longst common subsequences in both the string 
// the sum of remaining characters in both the strings is the answer , because the remaining character of string 1 needed to be added in string 2 
// and the remaining charcater of string 2 needs to be deleted

//01.RECURSION 
class Solution {
    public int minDistance(String word1, String word2) {
        //WE NEED TO FIND THE COMMON PART IN BOTH THE STRING AND REST CHARACTERS IN BOTH THE STRING WILL BE THE ASNWER
       int n1 = word1.length();
       int n2= word2.length();
       //we need to get longest common subsequence 
       int lcs= helper (n1-1 , n2-1 , word1 , word2);
       return n1+n2-(2*lcs);
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

02.MEMOIZATION 

  class Solution {
    public int minDistance(String word1, String word2) {
        //WE NEED TO FIND THE COMMON PART IN BOTH THE STRING AND REST CHARACTERS IN BOTH THE STRING WILL BE THE ASNWER
       int n1 = word1.length();
       int n2= word2.length();
       //we need to get longest common subsequence 
       int [][]dp= new int [n1][n2];
       for(int i=0;i<n1;i++){
           Arrays.fill(dp[i],-1);
       }
       int lcs= helper (n1-1 , n2-1 , word1 , word2,dp);
       return n1+n2-(2*lcs);
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

  class Solution {
    public int minDistance(String word1, String word2) {
        //WE NEED TO FIND THE COMMON PART IN BOTH THE STRING AND REST CHARACTERS IN BOTH THE STRING WILL BE THE ASNWER
       int n1 = word1.length();
       int n2= word2.length();
       //we need to get longest common subsequence 
       int [][]dp= new int [n1+1][n2+1];
       int lcs= helper (n1 , n2 , word1 , word2,dp);
       return n1+n2-(2*lcs);
    }
   
   public static int helper( int index1 ,int index2 , String s1 , String s2, int [][]dp){

        for(int i=1;i<=index1;i++){
             for(int j=1;j<=index2; j++){

                 int take=0;
                 if(s1.charAt(i-1)==s2.charAt(j-1)) take = 1+ dp[i-1][j-1];
                 int left=dp[i-1][j];
                 int right = dp[i][j-1];

                 int nottake = Math.max(left,right);

                  dp[i][j]=Math.max(take,nottake);
             }
         }
         return dp[index1][index2];
        
    }
}

04.SPACE OPTIMIZATION 

  class Solution {
    public int minDistance(String word1, String word2) {
        //WE NEED TO FIND THE COMMON PART IN BOTH THE STRING AND REST CHARACTERS IN BOTH THE STRING WILL BE THE ASNWER
       int n1 = word1.length();
       int n2= word2.length();
       //we need to get longest common subsequence 
       int []dp= new int [n2+1];
       int lcs= helper (n1 , n2 , word1 , word2,dp);
       return n1+n2-(2*lcs);
    }
   
   public static int helper( int index1 ,int index2 , String s1 , String s2, int []dp){

        for(int i=1;i<=index1;i++){
            int temp []= new int [dp.length];
             for(int j=1;j<=index2; j++){

                 int take=0;
                 if(s1.charAt(i-1)==s2.charAt(j-1)) take = 1+ dp[j-1];
                 int left=dp[j];
                 int right = temp[j-1];

                 int nottake = Math.max(left,right);

                temp[j]=Math.max(take,nottake);
             }
             dp=temp;
         }
         return dp[index2];
        
    }
}

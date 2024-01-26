01.RECURSION

  class Solution {
    public boolean isMatch(String s, String p) {
        //we need to check if s is equal to p 
        int n= s.length();
        int m = p.length();
         return helper(n-1,m-1,s,p);
    }
    public boolean helper(int index1 , int index2 , String s ,String p){
      
       if(index1<0 && index2<0){
         return true;
       }

       if( index1>=0 && index2<0)return false;

       if(index1<0){ 
//if index 1 is exhausted and index 2 is still there , it means if all stars are pending which can be equivalent to 0 then return false otherwise dont return false;
           for(int i=0;i<=index2;i++){
           if(p.charAt(i)!='*')return false;
           }
           return true;
       }

       if(s.charAt(index1)==p.charAt(index2) || p.charAt(index2)=='?')return helper(index1-1,index2-1,s,p);
       
       if(p.charAt(index2)=='*'){
       boolean considerxas0 = helper(index1,index2-1,s,p);
       boolean considerxas1Andmore = helper(index1-1 ,index2 , s,p);
       return considerxas0 || considerxas1Andmore;
       }
       return false;
    }
}



//  Boolean temp=false;
//        if(p.charAt(index2)=='*'){ //THIS DOESNT WORK BECAUSE AT A TIME LENGTH OF S1>0 AND S2<0 AND IT WILL RETURN FALSE BUT THE ANSWER SHOULD BE TRUE
//        for(int i=0;i<=index1;i++){
//            boolean sa = helper(index1-i,index2-1,s,p);
//            if(sa==true)temp=true;
//          }
//        }
//        return temp;

02.MEMOIZATION 

class Solution {
    public boolean isMatch(String s, String p) {
        //we need to check if s is equal to p 
        int n= s.length();
        int m = p.length();
        int dp[][]= new int [n][m];
        for(int i=0;i<n;i++){Arrays.fill(dp[i],-1);}
       return( helper(n-1,m-1,s,p,dp)==1) ?true:false;
    }
    public int helper(int index1 , int index2 , String s ,String p , int [][]dp){
       if(index1>=0 && index2>=0 && dp[index1][index2]!=-1)return dp[index1][index2];
       if(index1<0 && index2<0){
         return 1;
       }

       if( index1>=0 && index2<0)return 0;
       if(index1<0){ 
//if index 1 is exhausted and index 2 is still there , it means if all stars are pending which can be equivalent to 0 then return false otherwise dont return false;
           for(int i=0;i<=index2;i++)
           {
           if(p.charAt(i)!='*')return  0;
           }
           return 1;
       }

      
       if(s.charAt(index1)==p.charAt(index2) || p.charAt(index2)=='?')return helper(index1-1,index2-1,s,p,dp);
       
       if(p.charAt(index2)=='*'){
       int considerxas0 = helper(index1,index2-1,s,p,dp);
       int considerxas1Andmore = helper(index1-1 ,index2 , s,p,dp);
       if(considerxas0==1 || considerxas1Andmore ==1)return 1; 
       }
       return 0;
    }
}

03.TABULATION 
  class Solution
{
    public boolean isMatch(String s, String p)
    {
        //we need to check if s is equal to p 
        int n= s.length();
        int m = p.length();
        int dp[][]= new int [n+1][m+1];
       
       for(int i=0;i<=n;i++){
         dp[i][0]=0;
       }

       for(int j=0;j<=m;j++)
       {
        dp[0][j]=1;
        for(int k=0;k<j;k++)
        {
              if(p.charAt(k)!='*')
              {
              dp[0][j]=0;
              continue;
              }
        } 
      
       }
       for(int i=1;i<=n;i++){
           for(int j=1;j<=m;j++){

              if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?')dp[i][j]=dp[i-1][j-1];
               else if(p.charAt(j-1)=='*')
                 {
                    int considerxas0 = dp[i][j-1];
                    int considerxas1Andmore = dp[i-1][j];
                    if(considerxas0==1 || considerxas1Andmore ==1)dp[i][j]=1; 
                      
                 }
               else dp[i][j]=0;
           }

        }

      return dp[n][m]==1?true:false;
    
    
    }
}

04.SPACE OPTIMIZATION 

  class Solution
{
    public boolean isMatch(String s, String p)
    {
        //we need to check if s is equal to p 
        int n= s.length();
        int m = p.length();
        int dp[]= new int[m+1];
       
       for(int j=0;j<=m;j++)
       {
        dp[j]=1;
        for(int k=0;k<j;k++)
        {
              if(p.charAt(k)!='*')
              {
              dp[j]=0;
              continue;
              }
        } 
      
       }
       for(int i=1;i<=n;i++){
           int temp[]=new int[m+1];
          
           for(int j=1;j<=m;j++){

              if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?')temp[j]=dp[j-1];
               else if(p.charAt(j-1)=='*')
                 {
                    int considerxas0 = temp[j-1];
                    int considerxas1Andmore = dp[j];
                    if(considerxas0==1 || considerxas1Andmore ==1)temp[j]=1; 
                      
                 }
               else temp[j]=0;
           }
          dp=temp;
        }

      return dp[m]==1?true:false;
    
    
    }
}








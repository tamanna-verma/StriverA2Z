01.Recursion 

  public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
       
       return helper(n-1 ,3 , points);
       
    }
    public static int helper( int n , int last , int [][]points){
        if(n==0)
        {
             int max=Integer.MIN_VALUE;
            for(int i=0;i<3;i++)
            {
                if(last !=i)
                {
                 max=Math.max(max, points[0][i]);
                }     
            }
             return max;
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<points[0].length;i++)
        {
                
                if(last !=i)
                {
                 max=Math.max(max, (points[n][i] + helper(n-1,i,points)));
                }
               
        }
        return max;
        
    }

}


02.Memoization -TOP DOWN

  import java.util.Arrays;
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
       
    
       int [][]dp = new int [n][4];
       for(int i=0;i<dp.length;i++){
           Arrays.fill(dp[i],-1);
       }
       return helper(n-1 ,3 , points , dp);
       
    }
    public static int helper( int n , int last , int [][]points , int [][]dp){
        if(n==0)
        {
             int max=Integer.MIN_VALUE;

            for(int i=0;i<3;i++)
            {
                if(last !=i)
                {
                 max=Math.max(max, points[0][i]);
                
                }     
            }

             return dp[n][last]= max;
        }
        

         if( dp[n][last]!=-1)return dp[n][last];

        int max=Integer.MIN_VALUE;
        for(int i=0;i<points[0].length;i++)
        {
                
                if(last !=i)
                {
                 max=Math.max(max, (points[n][i] + helper(n-1,i,points, dp)));
                }
               
        }
        dp[n][last]=max;
        return max;
        
    }

}

03.Tabulation -Bottom Up

public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
      
     
      int [][] dp = new int [n][4];
      dp[0][0]= Math.max(points[0][1], points[0][2]);
      dp[0][1]= Math.max(points[0][0], points[0][2]);
      dp[0][2]= Math.max(points[0][0], points[0][1]);
      dp[0][3]=Math.max(points[0][0],Math.max(points[0][1],points[0][2]));

      for(int day=1;day<n;day++){
          for(int last =0;last<4;last++){
              int max=0;
              for(int task = 0;task<3;task++)
              {
                  if(task!=last)
                  {
                      max=Math.max(max , points[day][task] + dp[day-1][task]);
                  }

              }
              dp[day][last]=max;
          }
      }
      return dp[n-1][3];

    }

}

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold)
    {
   int [][]ans = new int [n][n];
    for(int i=0;i<n;i++){
         for(int j=0;j<n;j++){
           if(i==j)ans[i][j]=0;
           else ans[i][j]=(int)1e9;
         }
     }
    for(int i=0;i<edges.length;i++){
    int from  = edges[i][0];
    int to = edges[i][1];
    int value = edges[i][2];
    ans[from][to]=Math.min(ans[from][to],value);
    ans[to][from]=Math.min(ans[to][from],value);
  
    }
   
     
   
   for(int node=0;node<n;node++){
     for(int i=0;i<n;i++){
         for(int j=0;j<n;j++){
           
           if(ans[i][node]!=1e9 && ans[node][j] != 1e9){
             int newvalue = ans[i][node] + ans[node][j];
             if(ans[i][j]>newvalue)
             {
               ans[i][j]=newvalue;
             }
           }
         }
     }
   }
int count=Integer.MAX_VALUE;
int city=0;
        for(int i=0;i<n;i++){
            int temp=0;
         for(int j=0;j<n;j++)
         {
       if( i!=j && ans[i][j]<=distanceThreshold)temp++;
          }
            if(temp<=count)
            {
            count=temp;
            city=i;
            }
           }
        return city;

        
    }
}

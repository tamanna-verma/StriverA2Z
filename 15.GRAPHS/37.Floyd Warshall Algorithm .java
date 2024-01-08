public class Solution {
    public int[][] solve(int[][] ans) {
       //int graph[x][y] = graph[x][via] + graph[via][y];
   //int [][]ans = new int [n+1][n+1];
   int n=ans.length;
    for(int i=0;i<n;i++){
         for(int j=0;j<n;j++){
           if(ans[i][j]==-1) ans[i][j]=(int)1e8;
         }
     }
    // for(int i=0;i<edges.size();i++){
    // int from  = edges.get(i).get(0);
    // int to = edges.get(i).get(1);
    // int value = edges.get(i).get(2);
    // ans[from][to]=value;
  
    // }
   
     
   
   for(int node=0;node<n;node++){
     for(int i=0;i<n;i++){
         for(int j=0;j<n;j++){
           
           if(ans[i][node]!=1e8 && ans[node][j] != 1e8){
             int newvalue = ans[i][node] + ans[node][j];
             if(ans[i][j]>newvalue){
               ans[i][j]=newvalue;
             }
           }
         }
     }
   }
   
for(int i=0;i<n;i++){
         for(int j=0;j<n;j++){
           if(ans[i][j]==(int)1e8)ans[i][j]=-1;
         }
     }
   return ans;
    }
}

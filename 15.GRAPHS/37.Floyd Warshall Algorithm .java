//scaler floyd warshall code
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





//coding ninjas floyd warshall code 
import java.util.ArrayList;

public class Solution {
  static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
   
   //int graph[x][y] = graph[x][via] + graph[via][y];
   int [][]ans = new int [n+1][n+1];
    for(int i=1;i<n+1;i++){
         for(int j=1;j<n+1;j++){
           if(i==j)ans[i][j]=0;
           else ans[i][j]=(int)1e9;
         }
     }
    for(int i=0;i<edges.size();i++){
    int from  = edges.get(i).get(0);
    int to = edges.get(i).get(1);
    int value = edges.get(i).get(2);
    ans[from][to]=value;
  
    }
   
     
   
   for(int node=1;node<n+1;node++){
     for(int i=1;i<n+1;i++){
         for(int j=1;j<n+1;j++){
           
           if(ans[i][node]!=1e9 && ans[node][j] != 1e9){
             int newvalue = ans[i][node] + ans[node][j];
             if(ans[i][j]>newvalue){
               ans[i][j]=newvalue;
             }
           }
         }
     }
   }

// for(int i=1;i<n+1;i++){
//   for(int j=1;j<n+1;j++){
//     if(i==j && ans[i][j]<0)
//     //it means there is a negative cycle
//   }
// }
    return ans[src][dest];

//negative cycles , if n to n distance is less than 0 then negative cycles
  
  }

}


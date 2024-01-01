import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static int[][] printAdjacency(int n, int m, int[][] edges) {
    
    // we need to return a adj matrix 
List<Integer> adj[] = new ArrayList [n];
for(int i=0;i<n;i++){
   adj[i]= new ArrayList<Integer>();
}

for(int i=0;i<m;i++){
   int from = edges[i][0];
   int to =edges[i][1];
   adj[from].add(to);
   adj[to].add(from);
}

int [][]ans = new int [n][];
for(int i=0;i<adj.length;i++){
   int temp[]=new int [adj[i].size()+1];
   temp[0]=i;
   for(int j=0;j<adj[i].size();j++){
      temp[j+1]=adj[i].get(j);
   }
   ans[i]=temp;
}
return ans;

// 0 30
// 1 21
// 2 132
// 3 023


   //     // so there are n nodes and m edges 
   //  //    ArrayList < ArrayList<Integer> > adj= new ArrayList<>();
   //  //   //
   //    ArrayList <Integer> adj[] = new ArrayList [n+1];

   //    for(int i=0;i<edges.length ;i++){
   //        int x= edges[i][0];
   //        int y =edges[i][1];
   //        // now that we have x and y 
   //        adj[x].add(y);
   //       // adj[y].add(x);

   //    }
   //     for(int i=0;i<adj.length ;i++){
   //       System.out.print(i+" ");
   //       for(int j=0;j < adj[i].size();j++){
   //          System.out.print(adj[i].get(j)+" ");
   //       }
   //     }

      
       
    }
}

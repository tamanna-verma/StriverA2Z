import java.util.*;
 import java.util.ArrayList;
public class Solution {

//first of all , we will be creating a stack , 
//whichever node is visited and all its adjnodes are visited
// put them into the stack 
//then we empty the stack in ans arraylist

    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
     
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      for(int i=0;i<v;i++){
          adj.add(new ArrayList<Integer> ());
      }
      for(int i=0;i<edges.length;i++){
          int from = edges[i][0];
          int to = edges[i][1];

          adj.get(from).add(to);
      }

      int visited[]=new int [v];
      Stack<Integer> stack= new Stack<>();
      ArrayList<Integer> ans= new ArrayList<>();
       for(int i=0;i<v;i++){
          if(visited[i]==0){
              dfs( i, visited , adj , ans , stack);
          }
         
       }
      
      while(!stack.isEmpty()){
          ans.add(stack.pop());
      }
      return ans;
    }

public static  void dfs(int node , int[] visited ,ArrayList<ArrayList<Integer>> graph , ArrayList<Integer> ans , Stack<Integer> stack){
    visited[node]=1;
    for(int i=0;i<graph.get(node).size();i++){
        int curr=graph.get(node).get(i);
        if(visited[curr]==0)dfs(curr , visited , graph , ans , stack);
    }
    stack.push(node);
}


}

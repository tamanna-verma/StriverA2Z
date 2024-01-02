import java.util.List;
public class Solution {
    static class Graph {
        boolean detectCycle(int V, List<List<Integer>> adj) {
            int[]visited= new int [V+1];
           for(int i=0;i<V;i++){
               if(visited[i]==0){
                 if(dfs(-1, i, adj, visited)==true)return true;
               }
           }
           return false;
        }

        public boolean dfs(int parent , int node , List<List<Integer>> adj , int[] visited){
            visited[node]=1;

            for(int i=0;i<adj.get(node).size();i++){
                int x= adj.get(node).get(i);
                if(visited[x]==1 && x!=parent)return true;
                else if(visited[x]==0)
                {
                    boolean smallans= dfs(node, x , adj, visited);             
                    if(smallans==true)return true;
                }

            }
            return false;
        }
    };
}

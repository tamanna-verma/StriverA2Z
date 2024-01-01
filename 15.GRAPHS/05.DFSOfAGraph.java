
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        int start=0;
       int visited[]=new int [V+1];
       visited[0]=1;
       dfs(0 ,  ans , adj,visited);
        return ans;
    }
    public ArrayList<Integer> dfs(int start , ArrayList<Integer> ans , ArrayList<ArrayList<Integer>>adj, int visited[]){
        
        if(adj.get(start).size()==0)return ans;
        
        ans.add(start);
        visited[start]=1;
        for(int i=0;i<adj.get(start).size();i++){
            if(visited[adj.get(start).get(i)]!=1){
          ans=   dfs(adj.get(start).get(i), ans, adj,visited);
        }
        }
        
        return ans;
    }
}

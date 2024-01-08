class Pair{
    int node;
    int color;
    Pair(int node, int color){
        this.node=node;
        this.color=color;
    }
    
}
class Solution {
    public boolean isBipartite(int[][] graph) {
      int n=graph.length;
       int []visited = new int [n];
        
        for(int i=0;i<n;i++){
            if(visited[i]==0){
            boolean sa = dfs(visited , i , -1, graph);
            if(sa==false)return false;
            }
        }
        return true;
    }
    public static boolean dfs(int []visited , int node ,int parent, int graph[][]){
        if(parent==-1)visited[node]=1;
        else
        {
            int oldcolor= visited[parent];
            int newcolor = (oldcolor==1)?2:1;
            visited[node]=newcolor;
        }
        
        for(int i=0;i<graph[node].length;i++){
            int adjnode= graph[node][i];
            
            if(visited[adjnode]==visited[node])return false;
            else if(visited[adjnode]==0)
            {
              boolean sa =  dfs(visited , adjnode , node , graph);
                if(sa==false)return false;
            }
        }
        return true;
    }
}

//agar graph bipartite hai
// it means it can be coloured by just 2 colors where no 2 nodes have same color

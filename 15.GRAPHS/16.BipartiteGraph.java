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
        //we need to start with the node 0 and put it in queue
        //pop the element and check if its adjacent are visited or not 
        // , if not visited , color then with different color and if they are already colored then we can check if the color is same then return false 
        //     else if no case is found as false then return true;
        // if there is even length cycle or the graph is linear and have no cycle then it can be a bipartite graph 
        //we will be marking visited by 1& 2 as the colors
         int []visited=new int[graph.length];
        for(int k=0;k<graph.length;k++){
            if(visited[k]==0){
       
        Queue<Pair> queue = new LinkedList();
        queue.add( new Pair(k,1) );
        visited[k]=1;
        
        while(!queue.isEmpty()){
            Pair popped= queue.remove();
            int node = popped.node;
            int color= popped.color;
            
            for(int i=0;i<graph[node].length;i++){
                
                int colorpresent=visited[graph[node][i]];
                if(colorpresent!=0){
                    if(colorpresent==color && graph[node][i]!=node)return false;
                }
                else if(colorpresent==0){
                    if(color==1)
                    {
                    queue.add(new Pair(graph[node][i] , 2));
                    visited[graph[node][i]]=2;
                    }
                    else{
                    queue.add(new Pair(graph[node][i] , 1));
                    visited[graph[node][i]]=1; 
                    }
                    
                }
            }
        }
            }
        }
        return true;
        
        
    }
}

//agar graph bipartite hai
// it means it can be coloured by just 2 colors where no 2 nodes have same color

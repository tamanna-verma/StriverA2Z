class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
       Queue<Integer> queue= new LinkedList<>();
       int visited[]=new int [V];
       ArrayList<Integer> ans=new ArrayList<>();
       int i=0;
    //   for(int i=0;i<V;i++){
           
           if(visited[i]==0){
               queue.add(i);
               visited[i]=1;
               
               while(!queue.isEmpty()){
                   int popped= queue.remove();
                   ans.add(popped);
                   for(int j=0;j<adj.get(popped).size();j++)
                   {
                       if(visited[adj.get(popped).get(j)]==0 )
                       {
                           queue.add(adj.get(popped).get(j));
                           visited[adj.get(popped).get(j)]=1;
                       }
                   }
               }
           }
           
           
       //}
       return ans;
    }
}

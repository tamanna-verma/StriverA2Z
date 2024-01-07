import java.util.*;
class Pair{
    int node ;
    int weight;
    Pair(int node , int weight){
        this.node=node;
        this.weight= weight;
    }
}
public class Solution {
    public static int[] shortestPathInDAG(int n, int m, int [][]edges) {
        //in directed acyclic graph , if we want the shortest path , 
        // first find the topological sort and then find the 
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>(); 
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<Pair>());
        }

        for(int i=0;i<edges.length;i++){
            int from =edges[i][0];
            int to = edges[i][1];
            int weight = edges[i][2];
            Pair pair = new Pair(to , weight);

            graph.get(from).add(pair); 
        }
        Stack<Integer> stack = new Stack<>();
        int []visited= new int [n];
       
        // now that we have toposort in hand ;
        // for(int i=0;i<n;i++){
            // if(visited[i]==0)
            dfs(0 , visited , graph , stack);
        // }
        int []distance= new int [n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[stack.peek()]=0;

        while(!stack.isEmpty()){
            int node= stack.pop();
            int tillnow= distance[node];

            for(int i=0;i<graph.get(node).size();i++){
                Pair curr= graph.get(node).get(i);

                int to = curr.node;
                int weight = curr.weight;

              int newweight = tillnow+weight;

              if(distance[to]> newweight){
                  distance[to]=newweight;
              }

            }
        }
       for(int i=0;i<n;i++){
           if(distance[i]==Integer.MAX_VALUE)distance[i]=-1;
       }
        return distance;

    }
    public static void dfs(int node , int visited[] , ArrayList<ArrayList<Pair>> graph , Stack<Integer> stack){
        
        visited[node]=1;

        for(int i=0;i<graph.get(node).size();i++){
            Pair curr= graph.get(node).get(i);
            int to = curr.node;
            int weight = curr.weight;

            if(visited[to]==0)dfs(to , visited , graph , stack);
        }

        stack.add(node);
    }
}

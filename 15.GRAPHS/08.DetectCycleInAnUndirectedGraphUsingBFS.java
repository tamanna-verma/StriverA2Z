import java.util.*;
import java.util.List;
class Pair{
    int node;
    int parent;
    Pair(int node , int parent){
        this.node=node;
        this.parent=parent;
    }
}
public class Solution {
    static class Graph {
        boolean detectCycle(int V, List<List<Integer>> adj) {
            for(int k=0;k<V;k++){
           int [] visited=new int [V+1];
          Queue<Pair> queue=new LinkedList<>();
          queue.add(new Pair(k,-1));
          visited[k]=1;
           while(!queue.isEmpty()){
               Pair popped= queue.remove();
               int node =popped.node;
                int parent= popped.parent;
                for(int i=0;i<adj.get(node).size();i++){
                    if(visited[adj.get(node).get(i)]==1 && adj.get(node).get(i)!=parent){
                        return true;
                    }
                    else if(visited[adj.get(node).get(i)]==0 ) {
                        queue.add(new Pair(adj.get(node).get(i),node));
                        visited[adj.get(node).get(i)]=1;
                    }
                }
           }
        //  return false;
            }
             return false;
        }
    };
}
// so we need to detect the cycle in a graph
// agar vo node visit hochuki hai aur hum vapas se uspe traverse krre hai
//aur vo parents node b nahi hai to iska matlab there is a cycle present


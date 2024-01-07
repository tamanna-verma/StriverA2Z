import java.util.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;



class Pair{
    int node ;
    int weight;

    Pair (int node , int weight){
        this.node= node;
        this.weight=weight;
    }

}
class QPair {
    int distance;
    int node;
    QPair (int distance , int node ){
        this.distance= distance;
        this.node=node;
        
    }
}
public class Solution {
    public static List<Integer> dijkstra(int[][] edge,int vertices, int edges,int source){
        //WE NEED TO PERFORM DIJKSTRA ALGORITHM OVER HERE 
        // WE USE PRIORITY QUEUE IN DIJKSTRA 
        PriorityQueue<QPair> pq = new PriorityQueue<QPair>((a,b)-> a.distance - b.distance);
        int []distance= new int [vertices];
        Arrays.fill(distance , Integer.MAX_VALUE);
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i=0;i< vertices;i++){
            graph.add(new ArrayList<Pair>());
        }
        int[] visited=new int[vertices];
        visited[source]=1;
        for(int i=0;i<edge.length;i++){
            int from = edge[i][0];
            int to = edge[i][1];
            int weight = edge[i][2];

            Pair pair = new Pair(to , weight);
            Pair second= new Pair(from , weight);
            graph.get(from).add(pair); 
            graph.get(to).add(second);
        }
        //ab graph bngya
        distance[source]=0;
        QPair pair= new QPair(0,source);
        pq.add(pair);

        while(!pq.isEmpty()){
            QPair qpair = pq.remove();
            int olddistance= qpair.distance;
            int node = qpair.node;
              visited[node]=1;

              
            for(int i=0;i<graph.get(node).size();i++){
                Pair curr= graph.get(node).get(i);
                  int newnode = curr.node;
                  int weight = curr.weight;

                  int newdistance= weight+ olddistance;
                  if(distance[newnode]>newdistance){
                      distance[newnode]=newdistance;
                  }
                 if(visited[newnode]==0) pq.add(new QPair(distance[newnode] , newnode));
                
                
            }
        }
        ArrayList<Integer> ans= new ArrayList<>();
       for(int value : distance){
           ans.add(value);
       }

return ans;
    }
}

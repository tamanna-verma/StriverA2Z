import java.util.*;

class QPair{
    int weight;
    int node;
     QPair(int weight , int node){
         this.weight=weight;
         this.node=node;
     }
}

//we need to return the minimum time it takes to send the signal 
        //shortest path algorithm 
        //dijkstra
class graphPair{
    int node;
     int weight;
    graphPair(int node, int weight){
        this.node=node;
        this.weight=weight;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        int time[]= new int [n+1];
        Arrays.fill(time,Integer.MAX_VALUE);
        time[k]=0;
        
        PriorityQueue<QPair> pq = new PriorityQueue<>(Comparator.comparingInt(QPair ->QPair.weight));
        
        ArrayList<ArrayList<graphPair>> graph = new ArrayList();
        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<graphPair>());
        }
        for(int i=0;i<times.length;i++){
            int from =times[i][0];
            int to = times[i][1];
            int timing= times[i][2];
            
            graph.get(from).add(new graphPair(to,timing));
            
        }
        pq.add(new QPair(0,k));
        while(!pq.isEmpty())
        {
            QPair removed = pq.remove();
            int node= removed.node;
            int timetillnow= removed.weight;
            
            for(int i=0;i<graph.get(node).size();i++){
                int newnode = graph.get(node).get(i).node;
                int newtime =graph.get(node).get(i).weight;
                
                int lowertime=timetillnow+newtime;
                
                if(time[newnode]>lowertime){
                    pq.add(new QPair(lowertime , newnode));
                    time[newnode]=lowertime;
                }
                
            }
            
        }
        int ans =Integer.MIN_VALUE;
        for(int i=1;i<time.length;i++){
            if(i==k)continue;
            else if(time[i]>ans)ans=time[i];
            // System.out.print(time[i]+" ");
        }
       if(ans==Integer.MAX_VALUE)return -1;
        else return ans;
    }
    
}

import java.util.*;
public class Solution {
    public static int[] shortestPath(int n, int [][]edges, int src) {
        int []ans = new int [n];
      
        Arrays.fill(ans,Integer.MAX_VALUE);
        Queue<Integer> queue= new LinkedList<>();
        queue.add(src);
        int []visited = new int [n];
          ans[src]=0;
        visited[src]=1;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            int first = edges[i][0];
            int second = edges[i][1];

             graph.get(first).add(second);
             graph.get(second).add(first);
        }

        while(!queue.isEmpty()){
            int popped= queue.remove();
            int distance =ans[popped];

            for(int i=0;i<graph.get(popped).size();i++){
                int curr= graph.get(popped).get(i);
               
                  int olddistance= ans[curr] ;
                  int newdistance = distance + 1;
                  if(olddistance>newdistance)
                  {
                      ans[curr]=newdistance;
                  }
                 if(visited[curr]==0) queue.add(curr);
                  visited[curr]=1;
            }
        }
        for(int i=0;i<ans.length;i++){
            if(ans[i]==Integer.MAX_VALUE)ans[i]=-1;
        }
        return ans;
    }
}

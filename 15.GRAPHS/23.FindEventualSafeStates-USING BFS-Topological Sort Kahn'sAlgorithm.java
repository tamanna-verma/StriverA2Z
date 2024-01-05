//we need to do eventual safe states using bfs
// we can do it using topological sort method - kahn's algorithm 
// we will be reversing the edges 
// if there was an edge from 0-> 1 , then we do it from 1->0
// in this way , we will get terminal nodes easilt 
// the terminal nodes are the nodes where we will be having the indegrees as 0;
// the terminal nodes , will have adjacent nodes where indegree will become 0 , and whoso ever will be having indegree 0 slowly slowly will be safe nodes , anything that is connected to a cycle will never be having the indegree 0 


// in dfs if we used to encounter a false from somewhere , we use to return false , that will not be a safe node otherwise if every adj child returned trued , then its a safe node

import java.util.*;
import java.util.Collections;
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n=graph.length;
        int []indegree= new int [n];  
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                int element= graph[i][j];   
                adj.get(element).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> queue= new LinkedList<>();
        for(int i=0;i<n;i++){
           if(indegree[i]==0)queue.add(i);
        }
        ArrayList<Integer> ans= new ArrayList<Integer>();
        
        while(!queue.isEmpty()){
            int popped= queue.remove();
            ans.add(popped);
            for(int i=0;i<adj.get(popped).size();i++){
                int curr= adj.get(popped).get(i);
                
                indegree[curr]--;
                if(indegree[curr]==0){
                    queue.add(curr);
                }
            }
        }
      Collections.sort(ans);
        return ans;
    }
}

import java.util.ArrayList;
import java.util.*;
// so we need to detect wheather there is a cycle in the directed graph 
    // so there can be 2 ways to detect 

    //1.Topological sort algorithm using dfs
    //2.Kahn's algorithm using bfs

    // 1.Topological Sort Algorithm that use dfs - 
    // In this algorithm , we use a stack , // whenever a node and all its adjacent 
    // elements are visited , we add it inside the stack 
    // we follow this dfs step for all the nodes 1 by 1 if its not visited
    // then in the end , we pop the elements of stack in an ans arraylist 
    // we now got the reversed that , and this is the correct linear ordering 

    //2 .Kahn's Algorithm 
    // get the array made of incoming edges / indegree of nodes
    // create a queue , put all the nodes / elements in queue where the indegree in 0;
    // then pop the element from the queue and add it in the ans arraylist
    // and reduce the indegree of all its adj elements
    // if the indegree of its adj elements become 0 , then add it in the queue
    //return the ans arraylist if its size is equal to the no. of vertices
    
    
public class Solution {
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
     Queue<Integer> queue = new LinkedList();
      int []indegree=new int[n+1];
  ArrayList<ArrayList<Integer>> graph= new ArrayList<>();
  for(int i=0;i<n+1;i++){
    graph.add(new ArrayList<Integer>());
  }
     for(int i=0;i<edges.size();i++){
       ArrayList<Integer> curr= edges.get(i);
       
          int first =curr.get(0);
          int second= curr.get(1);
           graph.get(first).add(second);
          indegree[second]++;
       
     }

    ArrayList<Integer> ans= new ArrayList<>();
    for(int i=1;i<n+1;i++){
       if(indegree[i]==0)queue.add(i);
    }

    while(!queue.isEmpty()){
      int popped = queue.remove();
      ans.add(popped);
      for(int i=0;i<graph.get(popped).size();i++){
        int curr= graph.get(popped).get(i);
        indegree[curr]--;
        if(indegree[curr]==0)queue.add(curr);
      }
    }
    if(ans.size()!= n)return true;
    else return false;
  }
}

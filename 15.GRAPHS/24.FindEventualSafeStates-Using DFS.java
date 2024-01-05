import java.util.*;
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int visited[]=new int[n];
        int path[]=new int [n];
        int safenode[]=new int [n];
        
          ArrayList <Integer> ans= new ArrayList<>();
           for(int i=0;i< n;i++)
             { 
               dfs(i , visited , path , graph , safenode);
             } 
       for(int i=0;i<n;i++)if(safenode[i]==1)ans.add(i);      
        return ans;
    }
   
    public boolean dfs(int node , int []visited , int path[] ,int [][]graph, int[]safenode){
        
        if(safenode[node]==1)return true;
        if(safenode[node]==2)return false;
        if(visited[node]==1 && path[node]==1){   
                safenode[node]=2;
                return false; 
            }
          
        visited[node]=1;
        path[node]=1; 
        
        if(graph[node].length==0){
            safenode[node]=1;
            path[node]=0;
            return true;
        }
       
        
        for(int i=0;i<graph[node].length;i++){
            
           int curr=graph[node][i];          
           if(dfs(curr , visited , path,graph , safenode)==false)
           {
               safenode[node]=2;
               path[node]=0;
               return false;
           }       
        }
        
          path[node]=0;
        safenode[node]=1;
        return true;
        
    }
}


// we need to check if a node is having a cycle or not ,
// if the node is visited and is there in the path before , it means there is a cycle 
// we will be maintaining 3 arrays = visited array , path array and safe node array 
// if its a terminal node i.e have no child then return true
// if a child is visited , but is not path visited , then its a safe node 
// if for a node's all adjacent chld return true i.e a safe node , it means it is also a safe node otherwise if even 1 return false(i.e it has a cycle then return false)



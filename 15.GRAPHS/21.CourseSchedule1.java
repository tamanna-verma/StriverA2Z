class Solution {
    
    //topological sort is only going to work on DAG
    //use kahn's algorithm if you wish to find the cycles too
    
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();    
        for(int i=0;i<numCourses;i++)
        {
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int from = prerequisites[i][0];
            int to =  prerequisites[i][1];
            graph.get(from).add(to);
           
        }
        int visited[]=new int [numCourses];
         int path[]=new int [numCourses];
        
       
        for(int i=0;i<numCourses;i++)
        {
          if(visited[i]==0)
          {
          if(dfs(i , visited , path , graph )==false)return false;
          }
        }
       
        return true; 
    }
    
public static boolean dfs(int node , int [] visited, int[]path , ArrayList<ArrayList<Integer>>graph){
       
       
 if(  visited[node]==1 && path[node]==1) return false;
    if(visited[node]==1 )return true;
      visited[node]=1;
      path [node]=1;
        
        for(int i=0;i<graph.get(node).size();i++)
        {    
            int curr= graph.get(node).get(i);
            
            if(path[curr]==1)return false;
            
                  if(  dfs(curr , visited,path ,  graph )==false)
                  {
                      return false;
                  };
                }
                

        path[node]=0;
        return true;
        
    }
}
// 1->0->1 

  //we need to check which course can be performed one after the another
        //we are given the edges
        //we will be using a stack 
        // we will put in stack if there is a node which is visited and all its adjacent nodes are also visited 

//topological sort 
//we will do using dfs 
// if all the adjacent nodes are visited and current node is visited , then put it in the stack , 
// in the end , just empty the stack in a arraylist 
// if the size of the arraylist is same as that of the answer node

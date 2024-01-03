import java.util.*;
// import java.util.ArrayList();
public class Solution 
{
    public static Boolean isCyclic(int[][] edges, int v, int e)
    {
       //SO WE WILL BE MAINTAINING A VISITED AND PATH ARRAY 
       // TO KEEP A TRACK IF THE NODE HAS ALREADY BEEN VISITED AND IF THE NODE HAS BEEN A PART OF THE CURRENT PATH OR NOT
       
       ArrayList<ArrayList<Integer>> adjlist= new ArrayList<ArrayList<Integer>>();
       
       for(int i=0;i<v+1;i++){
           adjlist.add(new ArrayList<Integer>());
       }

        for(int i=0;i<edges.length;i++){
            int from = edges[i][0];
            int to = edges[i][1];
             adjlist.get(from).add(to);
        }
       int []visited = new int [v+1];
       int []path= new int [v+1];

       for(int i=0;i< v;i++){
           if(visited[i]==0){
             if( dfs(i , adjlist , visited , path)==true)return true;
           }
       }
       return false;
	}
    public static boolean dfs(int node , ArrayList<ArrayList<Integer>> adjlist , int []visited, int []path){
        visited[node]=1;


        for(int i=0;i<adjlist.get(node).size();i++ ){
            int curr= adjlist.get(node).get(i);
            
            if(path[curr]==1)return true;
             visited[curr]=1;

             path[curr]=1;

             if(dfs(curr,adjlist, visited , path)==true)return true;

             path[curr]=0;

            // so we have the current node now , we need to check if this node has been visited or not and if this is in the current path or not , 
            //if this node is already present in the current path then there exist a cycle
        }
   
        return false;
    }
}

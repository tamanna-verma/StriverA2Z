import java.util.*;
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
      // we will be solving it using kahn's algorithm
        // we need to do it using kahn's algorithm 
         int []indegree = new int [numCourses];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> graph= new ArrayList<>();
        for(int i=0;i<numCourses;i++){          
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            
            graph.get(to).add(from);
            indegree[from]++;
            
        }
        
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
      int[]ans= new int[numCourses];
        int count=0;
    
        while(!queue.isEmpty()){
            int popped = queue.remove();
            ans[count]=popped;
            count++;
            
            for(int i=0;i< graph.get(popped).size();i++){
                int curr= graph .get(popped).get(i);
                
                indegree[curr]--;
                if(indegree[curr]==0)queue.add(curr);
            }   
        }
        
        if(count==numCourses)return ans;
        else return new int[0];
       
        
    }
}

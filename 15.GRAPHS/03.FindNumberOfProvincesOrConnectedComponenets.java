// import java.util.List;
import java.util.*;
public class Solution {
    public static int findNumOfProvinces(int[][] roads, int n) {
       //we need to find number of provinces 
       //no. of provinces / no. of connected components 

       int visited[]= new int [n+1];
       

       Queue<Integer> queue = new LinkedList<>();
       int count=0;

       for(int i=0;i<n;i++){
           if(visited[i]==0){

               queue.add(i);
               visited[i]=1;
               count+=1;

               while(!queue.isEmpty()){
                   int popped = queue.remove();                  
                   for(int j=0;j<n;j++)
                   {
                      if(roads[popped][j]==1&& visited[j]==0)
                      {
                        queue.add(j);
                        visited[j]=1;                  
                      }
                   }
               }
               
           }
       }
    //   System.out.println(count);
       return count;

    }
}

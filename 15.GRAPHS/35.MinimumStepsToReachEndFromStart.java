import java.util.*;
class Pair{
int step;
 int node;
 Pair(int step , int node){
     this.step=step;
     this.node=node;
 }
}
public class Solution {
    public static int minimumOperations(int n, int start, int end, int []a) {
       Queue<Pair> queue = new LinkedList<>();
       int distance[]= new int [100000];
       queue.add(new Pair(0 , start));
       Arrays.fill(distance, Integer.MAX_VALUE);

       distance[start]=0;
       while(!queue.isEmpty()){
           Pair popped = queue.remove();
           int node = popped.node;
           int steps = popped.step;

           for(int i=0;i<a.length;i++){
               int newnode = a[i]*node;
               if(newnode>=1e3)newnode%=1e3;
               if(distance[newnode]> steps+1){
                   if(newnode==end)return steps+1;
                   queue.add(new Pair(steps+1, newnode));
                   distance[newnode]=steps+1;
               }
           }
       }
       if(distance[end]==Integer.MAX_VALUE)return -1;
       else return distance[end];


    }
}

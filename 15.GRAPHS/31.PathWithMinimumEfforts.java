import java.util.*;
import java.util.Comparator;
class Pair{
    int effort;
    int i;
    int j;
    int value;
    Pair(int effort, int i , int j , int value ){
        this.effort=effort;
        this.i=i;
        this.j=j;
        this.value=value;
    }
}
class Solution {
    public int minimumEffortPath(int[][] height) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair-> Pair.effort));
        
        int n=height.length;
        int m=height[0].length;
        
        int efforts[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                efforts[i][j]=Integer.MAX_VALUE;
            }
        }
        int visited[][]=new int[n][m];
           
        efforts[0][0]=0;
        
        pq.add(new Pair(0 , 0 , 0 ,height[0][0]));
        
        while(!pq.isEmpty()){
            Pair removed= pq.remove();
           
            int efforttillnow=removed.effort;
            int i=removed.i;
            int j=removed.j;
            int oldvalue = removed.value;
             visited[i][j]=1;
            
            int []deltax={+1,-1,0,0};
            int []deltay={0,0,+1,-1};
            
            for(int k=0;k<4;k++){
                
                int newx=deltax[k]+i;
                int newy=deltay[k]+j;
                if(newx>=0 && newx<n&&newy>=0 && newy <m)
                {
                    
                int newvalue = height[newx][newy];
                int currentefforts= Math.abs(newvalue-oldvalue); 
                    int maxefforts=Math.max(currentefforts, efforttillnow);
                
                    if(visited[newx][newy]==0 && maxefforts<efforts[newx][newy])
                    {           
                    pq.add(new Pair(maxefforts , newx, newy ,newvalue));
                  
                    efforts[newx][newy]=maxefforts;
                    }
                }
              
            }
        }
        return efforts[n-1][m-1];
        
    }
}

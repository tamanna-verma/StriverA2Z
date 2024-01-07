import java.util.*;
class Pair {
    int distance;
    int i;
    int j;
    Pair(int distance , int i , int j ){
        this.distance=distance;
        this.i=i;
        this.j=j;
    }
    
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        
        int visited[][]= new int [n][m];
        int distance[][]=new int [n][m];
        if(grid[0][0]==1)return -1;
       
        for(int i=0;i<distance.length;i++){
            for(int j=0;j<distance[i].length;j++){
                distance[i][j]=Integer.MAX_VALUE;
            }
        }
         distance[0][0]=0;
        Pair source = new Pair(0,0,0);
        Queue<Pair> queue= new LinkedList<>();
        queue.add(source);
        visited[0][0]=1;
        
        while(!queue.isEmpty()){
            Pair popped = queue.remove();
            int dist= popped.distance;
            int x=popped.i;
            int y =popped.j;
            
            int deltax[]={+1,-1,0,0,+1,-1,-1,+1};
            int deltay[]={0,0,+1,-1,+1,-1,+1,-1};
            
            for(int i=0;i<8;i++){
                int newx=deltax[i]+x;
                int newy=deltay[i]+y;
                int newdistance = dist+1;
               
                if(newx>=0 && newx<n && newy>=0 && newy<n  && visited[newx][newy]==0 &&  distance[newx][newy] > newdistance){
                    if( grid[newx][newy] ==0 ){
                     distance[newx][newy]=newdistance;
                    visited[newx][newy]=1;
                    queue.add(new Pair(newdistance , newx, newy));
                    }
                }
            }
        }
        for(int i=0;i<distance.length;i++){
            for(int j=0;j<distance[i].length;j++){
                if(distance[i][j]==Integer.MAX_VALUE)distance[i][j]=-2;
            }
        }
        return distance[n-1][n-1]+1;
    }
}

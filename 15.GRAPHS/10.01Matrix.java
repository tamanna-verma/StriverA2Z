class Pair{
    int i;
    int j;
    int distance;
    Pair(int x, int y , int distance){
        this.i=x;
        this.j=y;
        this.distance=distance;
    }
    
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //this must be done using bfs , if we do it using bfs, the answer will go wrong 
        int n=mat.length;
        int m=mat[0].length;
        int [][] ans= new int [n][m];
        int [][] visited= new int [n][m];
        Queue<Pair> queue=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(mat[i][j]==0){
                    queue.add(new Pair(i , j , 0));
                    visited[i][j]=1;
                }
            }
        }
        
        int deltaX[] = {+1,-1,0,0};
        int deltaY[] = {0,0,+1,-1};
       while(!queue.isEmpty()){
           Pair popped = queue.remove();
           int x= popped.i;
           int y=popped.j;
           int distance= popped.distance;
           ans[x][y]=distance;
           
           for(int i=0;i<4;i++){
               int newx =x+deltaX[i];
               int newy = y+deltaY[i];
               if(newx>=0 && newx<n && newy>=0 && newy<m && mat[newx][newy]==1 && visited[newx][newy]==0)
               {
                   queue.add(new Pair(newx,newy,distance+1));
                   visited[newx][newy]=1;
               }
           }
           
           
       }
        return ans;
        
    }
}

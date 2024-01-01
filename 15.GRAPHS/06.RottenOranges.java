class Pair{
    int x;
    int y;
    int time;
    Pair(int x, int y , int time){
        this.x=x;
        this.y=y;
        this.time=time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
            int[][] visited=new int[n][m];
        
        Queue<Pair> queue = new LinkedList<>();
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2)
                {
                queue.add(new Pair(i,j,0));
                visited[i][j]=1;
                }
            }
        }
        int ans=0;
        while(!queue.isEmpty()){
            Pair popped = queue.remove();
           int x=popped.x;
           int y=popped.y;
           int time=popped.time;
            
            ans=time;
            
            if( x-1 >=0 && grid[x-1][y]==1 && visited[x-1][y]==0){
                queue.add(new Pair(x-1,y,time+1));
                 visited[x-1][y]=1;
                  grid[x-1][y]=2;
            }
           
              if( x+1 <grid.length && grid[x+1][y]==1 && visited[x+1][y]==0){
                queue.add(new Pair(x+1,y,time+1));
                   visited[x+1][y]=1;
                   grid[x+1][y]=2;
            }
           
             if( y-1 >=0 && grid[x][y-1]==1 && visited[x][y-1]==0){
                queue.add(new Pair(x,y-1,time+1));
                  visited[x][y-1]=1;
                  grid[x][y-1]=2;
            }
            
             if( y+1 <grid[0].length && grid[x][y+1]==1 && visited[x][y+1]==0){
                queue.add(new Pair(x,y+1,time+1));
                  visited[x][y+1]=1;
                  grid[x][y+1]=2;
            }
           
            
            
        }
        // return ans;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)return -1;
            }
        }
        return ans;
        
    }
}

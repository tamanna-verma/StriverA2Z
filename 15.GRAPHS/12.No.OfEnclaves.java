class Solution 
{
    public int numEnclaves(int[][] grid) 
    {
        int [][] visited = new int [grid.length][grid[0].length];
      
        for(int i=0;i<grid.length;i++){
            int j=0;           
         if(grid[i][j]==1)   dfs(i ,j , grid, visited);           
            j=grid[0].length-1;    
          if(grid[i][j]==1)   dfs(i ,j , grid, visited);
        }
        
        for(int j=0;j<grid[0].length;j++){
            int i=0;
           if(grid[i][j]==1)  dfs(i , j , grid , visited);
             i=grid.length-1;
           if(grid[i][j]==1)   dfs(i , j , grid , visited);
        }
        
        int count=0;
        
        for(int j=0;j<grid.length;j++){
            for(int k=0;k<grid[0].length;k++){
              if(grid[j][k]==1)count++;  
               // System.out.print(grid[j][k]);
            }
            System.out.println();
        }
        return count;
    }
    
    public void dfs(int i , int j , int [][]grid , int visited[][]){
        visited[i][j]=1;
        grid[i][j]=2;
        
        int deltaX[]={0,0,+1,-1};
        int deltaY[]={+1,-1, 0,0};
        
        for(int k=0;k<4;k++){
        int newx= i+deltaX[k];
        int newy= j+deltaY[k];
         
            if(newx>=0 && newx<grid.length && newy>=0 && newy<grid[0].length &&  grid[newx][newy]==1 && visited[newx][newy]==0 ){
                dfs(newx,newy , grid, visited);
            }
        }
        
    }
}

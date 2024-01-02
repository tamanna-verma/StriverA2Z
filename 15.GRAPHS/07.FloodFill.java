// we have done the flood fill using basic bfs
class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int[][]visited=new int [image.length][image[0].length];
        Queue<Pair> queue=new LinkedList();
        queue.add(new Pair(sr,sc));
         int before=image[sr][sc];
        visited[sr][sc]=1;
        image[sr][sc]=color;
       
        
         int[] deltaX = {+1,-1,0,0};
         int[] deltaY = {0,0,+1,-1};
        
        
        while(!queue.isEmpty()){
            Pair popped=queue.remove();
            
            
            for(int i=0;i<deltaX.length;i++){
                int newx=popped.x+deltaX[i];
                int newy=popped.y+deltaY[i];
                
if(newx>=0 && newx<image.length && newy>=0 &&newy<image[0].length && image[newx][newy]==before && visited[newx][newy]==0){
                    queue.add(new Pair(newx, newy));
                    image[newx][newy]=color;
                    visited[newx][newy]=1;
                    
                }
            }
            
        }
        return image;
        
    }
}

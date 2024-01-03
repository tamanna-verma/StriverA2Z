class Solution {
    public void solve(char[][] board)
    {
        int n=board.length;
        int m =board[0].length;
        char [][] extra =new char [n][m];
       int [][] visited= new int [n][m];
        for(int i=0;i<board.length;i++){
            int j =0;            
           if(board[i][j]=='O') dfs(i , j , visited , board , extra);         
            j=board[0].length-1;
            if(board[i][j]=='O')  dfs(i , j , visited, board , extra);   
        }
        
        for(int j=0;j<board[0].length;j++){
            int i=0;
            if(board[i][j]=='O')  dfs(i , j , visited, board, extra);
             i=board.length-1;
            if(board[i][j]=='O')  dfs(i , j , visited, board, extra);
        }   
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(extra[i][j]!='2')board[i][j]='X';
            }
        }
        
    }
    
    public void dfs (int i , int j , int [][]visited ,char [][]board , char extra[][]){
        
        int n=board.length;
        int m=board[0].length;
        
        visited[i][j]=1;
        extra[i][j]='2';
        
        int deltaX[]={0,0,+1,-1};
        int deltaY[]={+1,-1,0,0};
        
        for(int k=0;k<4;k++){
            int newx=i+deltaX[k];
            int newy=j+deltaY[k];
            
            if(newx>=0 && newx<n && newy>=0 && newy<m && visited[newx][newy]==0 && board[newx][newy]=='O'){
                dfs(newx,newy, visited,board, extra);
            }
        }
        
        
    }
}
//so whatever is connected to the boundary in any way , that 0 cant be converted to x;
// , whichever is surrounded by x in all directions, only they can be converted , so we will be doing boundary dfs here also 

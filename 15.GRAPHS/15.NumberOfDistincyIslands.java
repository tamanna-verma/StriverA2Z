import java.util.*;
public class Solution 
{
	public static int distinctIsland(int [][] arr, int n, int m) 
	{
		int count=0;
		int[][] visited=new int [n][m];
		HashSet<String> set = new HashSet<>();
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(arr[i][j]==1 && visited[i][j]==0){
				 StringBuilder str=new StringBuilder("");
				 str=dfs(i,j,i,j,arr,visited,str);
				 String s=str.toString();
				 if(!set.contains(s))set.add(s);
				}
			}
		}
		return set.size();
	}
		public static StringBuilder dfs (int si , int sj ,int i , int j , int [][] arr , int [][] visited , StringBuilder str){
			visited[i][j]= 1;
			 int ansi= i-si;
			 int ansj= j-sj;
			str= str.append(" "+ansi).append(" "+ansj);
             
			int []deltaX= {0,0,+1,-1};
			int []deltaY= {+1,-1,0,0};

			 Boolean flag=false;
			 for(int k=0;k<4;k++){
				 int newx= i+deltaX[k];
				 int newy= j+deltaY[k];

				 //so now we are having deltaX and deltaY
				  if(newx>=0 && newx<arr.length && newy>=0 && newy<arr[0].length 
				&& arr[newx][newy]==1 && visited[newx][newy]==0){
                flag=true;
				str= dfs(si , sj , newx, newy , arr, visited, str);
				}
			 }
			 if(flag==false){
				 return str;
			 }
			 return str;
		}
		//we need to tell number of unique islands which are present by shape 
	
}

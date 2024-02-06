class Solution {
    public int[] findPeakGrid(int[][] mat) 
    {
        //we are going to find the peak element in the matrix 
          //we will go to middle row and find its max value , 
          //then check if its greater than left and right bcz its already greater than bottom and up
      //now we need to check if the left is greater then move to left //otherwise move to right 
      //we can return any peak 


        int n=mat.length;
        int m=mat[0].length;

        int low=0;
        int high=m-1;         
        while(low<=high){
            int midcol = low+((high-low)/2);
            int maxIndexRow = MaxInColumn(mat ,midcol);

            int val= mat[maxIndexRow][midcol];
            int left = midcol-1>=0 ? mat[maxIndexRow][midcol-1] :Integer.MIN_VALUE;
            int right = midcol+1<m ? mat[maxIndexRow][midcol+1] :Integer.MIN_VALUE;
            
            if(val>left && val>right)
            {
                int ans[]=new int [2];
                ans[0]=maxIndexRow;
                ans[1]=midcol;
                return ans;
            }
            else if(left >val)high=midcol-1;
            else low=midcol+1;
        }

         int ans[]=new int [2];
                ans[0]=-1;
                ans[1]=-1;
                return ans;
    }
    public static int MaxInColumn (int [][]matrix , int column)
    {
        int max=Integer.MIN_VALUE;
        int index=-1;
        int n=matrix.length;
        int m =matrix[0].length;
        for(int i=0;i<n;i++){
         if(matrix[i][column]>max){
             max=matrix[i][column];
             index = i;
         }
        }
        return index;
    }
}

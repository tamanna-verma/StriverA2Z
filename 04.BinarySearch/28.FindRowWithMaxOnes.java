import java.util.ArrayList;
public class Solution
{
    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m)
    {
        int max=0;
        int index=-1;
        for(int i=0;i<n;i++){
          int ones=NumberOfOnes(matrix.get(i));
          if(ones>max){
              max=ones;
              index=i;
          }
        }
        return index;
    }
  //we are finding the lower bound of 1 
    public static int NumberOfOnes(ArrayList<Integer> arr){
        int low=0;
        int high = arr.size()-1;
        int start=arr.size()-1;;
        
        while(low<=high){
            int mid = low+ ((high-low)/2);
            if(arr.get(mid)==1)
            {  start=mid;
                high=mid-1;
            }else low=mid+1;
        }

        return arr.size()-1-start;
    }
}

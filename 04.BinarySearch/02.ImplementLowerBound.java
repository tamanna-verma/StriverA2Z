public class Solution {
    public static int lowerBound(int []arr, int n, int x) {
       int ans =arr.length;
       int low = 0;
       int high = arr.length-1;

       while(low<=high)
       {
           int mid = low+ ((high-low)/2);
           if(arr[mid]>=x)
           {
               ans=mid;
               high=mid-1;
           }
           else {
               low=mid+1;
           }
       }
       return ans;
    }
}
//return the first index where the value is grater than or equal to x 


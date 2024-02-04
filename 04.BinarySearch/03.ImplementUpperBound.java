//RETURN FIRST INDEX WHERE THE VALUE IS GREATER THAN OF X

public class Solution {
    public static int upperBound(int []arr, int x, int n){
       
       int ans=n;
       int low=0;
       int high =n-1;

       while(!(low>high)){       
        int mid = low+ ((high-low)/2);
         if(arr[mid]>x){
             ans=mid;
             high=mid-1;
         }
         else if(arr[mid]<=x)low=mid+1;
       }
       return ans;
    }
}

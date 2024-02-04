class Solution {
    public boolean search(int[] arr, int target) {
          int low = 0;
         int high = arr.length-1;

         while(low<=high)
         {
             int mid  = low+ ((high-low)/2);
             
             //if left half is sorted 
             if(arr[mid]==target)return true;
              if(arr[low]==arr[mid] && arr[mid]==arr[high]) //if start , end and mid are equal then shrink the array 
              {
                  low++;
                  high--;
                  continue;
              }
             if(arr[low]<=arr[mid])
               {
                  if( arr[low]<=target && arr[mid]>=target)
                  {
                      high = mid-1;
                  }
                  else low = mid+1;
               }
              //if right half is sorted
               else 
               {
                  if(arr[mid]<=target && arr[high]>=target)
                  {
                      low = mid+1;
                  }
                 else high = mid-1;
               }
            
         }
         return false;

    }
}

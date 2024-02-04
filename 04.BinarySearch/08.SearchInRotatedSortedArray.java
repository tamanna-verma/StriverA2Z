class Solution {
    public int search(int[] arr, int target) {
         int low = 0;
         int high = arr.length-1;

         while(low<=high)
         {
             int mid  = low+ ((high-low)/2);
             
             //if left half is sorted 
             if(arr[mid]==target)return mid;
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
         return -1;

    }
}
//in completely sorted array , just checking for the one half was okay 
// 1.identify the sorted half - if its the left half or its the right half
// 2.now do the check for target in the sorted half 
// 3. if it is then do the binary search in the sorted half 
// 4. if target is not between the sorted half 
// 5.then search for it in the unsorted part 

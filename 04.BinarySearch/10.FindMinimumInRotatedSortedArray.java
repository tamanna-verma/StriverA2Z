class Solution {
    public int findMin(int[] arr) {
       
          int low = 0;
         int high = arr.length-1;
         int ans=Integer.MAX_VALUE;
         while(low<=high)
         {
             int mid  = low+ ((high-low)/2);
             
             //if left half is sorted 
       
              
             if(arr[low]<=arr[mid])
               {
                  if(arr[low]<ans)
                  {
                   ans=arr[low];
                  }
                  low = mid+1;
               }
              //if right half is sorted
               else 
               {
                  if(arr[mid]<ans)
                  {
                     ans=arr[mid];
                  }
                 high = mid-1;
               }
            
         }
         return ans;


    }
}

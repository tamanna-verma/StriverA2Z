class Solution {
    public int splitArray(int[] nums, int k) {
        
        //largest sum can be from 0 to sum of all
        int low=0;
        int high=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            high+=nums[i];
        }
         
         while(low<=high){
             int mid = low+ ((high-low)/2);

             if(isPossible(nums,mid, k)){
              high=mid-1;
              ans=mid;
             }
             else {
                low=mid+1;
             }
         }
        return ans;
       
    }

public boolean isPossible (int arr[] , int sum , int k ){
   
   int sa=1;
   int currsum=0;
   for(int i=0;i<arr.length;i++){
       if(currsum+arr[i]<=sum){
          currsum+=arr[i];
       }
       else{
           sa+=1;
        
           if(sa>k || arr[i]>sum)return false;
              currsum=arr[i];
       }
   }
   return true;
}
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        //we need to find the first index which is greater than or equal to the target value and we will return it 
        int n= nums.length;
        int ans= n;
        int low =0;
        int high = nums.length-1;

        while(!(low>high)){    
         int mid = low+ ((high-low)/2);
          if(nums[mid]>=target){
              ans=mid;
              high=mid-1;
          }
          else{
            low=mid+1;
          }
        }

       return ans;
    }
}

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
      //we have taken a low and a high , high will be the max element in array , and then divide the array by mid and check if the sum is 
      // equal or less than to target , if less than move towards left side otherwise right side for decreasing val of sum
        int low = 1;
        int high =  max(nums);
        int ans=-1;
        while(low<=high){
            int mid = low+ ((high-low)/2);

            if(sumOfQuotients(nums , mid)<=threshold){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;

        }
        return ans;

    }
    public static int max(int nums[]){
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max , nums[i]);
        }
        return max;
    }
    public int sumOfQuotients(int nums[] , int mid){
        int ans= 0;
        for(int i=0;i<nums.length;i++){
            ans+=Math.ceil((double)nums[i]/(double)mid);
        }
        return ans;
    }
}

class Solution {

  //if element is greater than left and right , it meaning it is peak
 // if mid greater than left , it means it is in increasing curve and move low to mid +1 and search in right side
// if mid is lesser than right , it means it is in decreasing curve , serach in left side and make high=mid-1
  
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        if(n==1)return 0;
        if(nums[0]>nums[1])return 0;
        if(nums[n-1]>nums[n-2])return n-1;
        int low=1;
        int high=n-2;
        while(low<=high)
        {
            int mid = low+ ((high-low)/2);//mid ki value milgyi hai 
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])return mid;
            if(nums[mid]<nums[mid+1])low=mid+1;
            else  if(nums[mid]<nums[mid-1]) high=mid-1;
        }

return -1;
    }
}
//here peak can be more than 1 

//low= from 0 and high =m-1 , we will find mid and we will see how many elements are missing till that index by finding - element - index 
// high will end up at a not posisble position , find the elements mising till high , and then do (k- elements missing till high ) + element at high

class Solution {
    public int findKthPositive(int[] arr, int k)
    {
       //so we will be doing binary search on answers 
       //we need to find kth missing number 
       int low=0;
       int high=arr.length-1;
       if(k<arr[0]) return k ;
       while(low<=high){
           int mid = low+(high-low)/2;
           if(findMissingTillN(mid,arr)<k){
               low=mid+1;
           }
           else {
               high=mid-1;
           }
       }
       return arr[high] + (k-(arr[high]-(high+1)));
    }
    public static int findMissingTillN(int index ,int arr[] ){
        int val = arr[index];
        int missing = val-(index+1);
        return missing;
    }
}

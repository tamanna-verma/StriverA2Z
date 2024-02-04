import java.util.*;
class Solution
{
    public int[] searchRange(int[] nums, int target) 
    {
        //we need to find the first position of an element in array and its last position 
        //if the array is sorted and we need to search something , then we will be thinking in the direction of binary search 
        if(nums.length==0){
            int arr[]=new int [2];
            arr[0]=-1;
            arr[1]=-1;
            return arr;
        }
        int first = FindFirstIndex(nums , target );
        int second = FindLastIndex(nums , target , 0 , nums.length-1 , -1);
       
       if(first==-1){                          //if the first occurrence is only not there, then there was no occurrence of the element
           int ans []=new int [2];
           Arrays.fill(ans,-1);
           return ans;
       }
      int ans []= new int [2];
        ans[0]=first;
        ans[1]=second;
         return ans;
    }
    public static int FindFirstIndex(int arr[] , int target){//iteratively
     int low=0;
     int high = arr.length-1;
     int ans = -1;

     while(low<=high){
         int mid = low+((high-low)/2);
         if(arr[mid]==target){                //if equal then update ans , search in left side for better
             ans=mid;
             high=mid-1;
         }
         else if(arr[mid]>target)
         {
             high=mid-1;
         }
         else if(arr[mid]<target){
             low=mid+1;
         }
     }
     return ans;
    }
    public static int FindLastIndex(int arr[] , int target , int low , int high, int ans){//recursively
        if(low>high)return ans;
        
        int mid = low+ ((high-low)/2);
        if(arr[mid]==target){                      //if equal then update ans , search in right side for better
            ans=mid;
            low=mid+1;
            return FindLastIndex(arr, target, low , high , ans);
        }
        else if(arr[mid]<target){
            low=mid+1;
            return FindLastIndex(arr, target, low , high , ans);
        }
        else{
            high=mid-1;
            return FindLastIndex(arr, target, low , high , ans);
        }
        
    } 
}

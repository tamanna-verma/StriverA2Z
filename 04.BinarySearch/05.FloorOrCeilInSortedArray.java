// floor= largest number in array <=x; = reversal of sign in lower bound , so instead of changing low , change high here 
//Ceil = smallest number in array >=x = lower bound

import java.util.* ;
import java.io.*; 

public class Solution {
    public static int[] getFloorAndCeil(int[] arr, int n, int x) {
     int flr= floor(arr, n , x);
     int cl = ceil (arr , n , x);
     int ans[]= new int [2];
     ans[0]=flr;
     ans[1]=cl;
    return ans;
    }
    public static int floor(int arr[], int n , int x){
      
     int low = 0;
     int high = n-1;
     int ans = -1;
     while(low<=high){
       int mid = low +((high-low)/2);
       if(arr[mid]<=x)
       {
        low=mid+1;
        ans=arr[mid];
       }
       else high = mid-1;      
     } 
     return ans;
    }
    public static int ceil(int arr[] , int n , int x){
     int low = 0;
     int high = n-1;
     int ans =-1;

     while(low<=high){

       int mid = low +((high-low)/2);
       if(arr[mid]>=x)
        {
         ans=arr[mid];
         high=mid-1;
        }
       else low=mid+1;
     }
     return ans;
    }

    
}

class Solution {
    public int singleNonDuplicate(int[] arr) {
        // either the left element should be same or the right 
        int n=arr.length;
        if(arr.length==1)return arr[0];
        if(arr[0]!=arr[1])return arr[0];
        if(arr[n-1]!=arr[n-2])return arr[n-1];

        int low=1;
        int high =n-2;

        while(low<=high){
          
          int mid = low+ ((high-low)/2);
          if(arr[mid-1]!=arr[mid] && arr[mid]!=arr[mid+1])return arr[mid];
        
           if((mid%2==0 && arr[mid+1]==arr[mid]) || mid%2==1 && arr[mid]==arr[mid-1] )low=mid+1; //eleminate the left 
          //else if((mid%2==1 && arr[mid-1] !=arr[mid])||( mid %2==0 && arr[mid]!=arr[mid+1]))high=mid-1; //eleminate the right
           else high=mid-1;
        } 
        return -1;
       
    }
}

// if we are at an index , if the element is on left or right , then we can say it is not single , but if it is not even on left or right , then that is the element we are looking for 
// to prevent index out of bound , we will start low from 1 and high from n-2;

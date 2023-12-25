// way 1 = linear search = o(n )
// way 2 = sort the array and find the largest 

import java.util.* ;
import java.io.*; 

public class Solution {

    static int largestElement(int[] arr, int n) {
        int largest =0;
        for(int i=0;i<n;i++){
          if( largest<arr[i])largest = arr[i];
        }
        return largest;

    }
}

// quick sort = first do the sort and then return the last element 
// we will be sorting using quicksort and return the last element = o (n log n )
// take the pivot as start element 
// while current element is less than pivot , i++
// while current element is greater than pivot , j--
// swap elements at i and j 
// if i > j then swap elements at pivot and j 
// then do the recursive calls for elements in left of j and elements on right of j 

import java.util.* ;
import java.io.*; 

public class Solution {

    static int largestElement(int[] arr, int n) {
       //we will do the quick sort 
       // find a pivot element , put it at its correct position and then put smaller on left and greater on right 
        
        int start=0;
        int end = n-1;
        int pivot = 0;

        partition(start , end , pivot , arr);
      //  for(int i=0;i< arr.length;i++)System.out.print(arr[i]);
        return arr[n-1];
    }
    public static void partition ( int start , int end , int pivot , int arr[]){
        if(start >=end || start >= arr.length || end < 0) return;
        int i=start;
        int j=end;
        while(i<=j)
        {
            while(i<=end && arr[pivot]>=arr[i]) i++;
            while(j>=start && arr[pivot]<=arr[j])j--;
            //swap the 2 
            if(i<=j)
            {
            int temp =arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            }
        }

        int temp = arr[pivot];
        arr[pivot] = arr[j];
        arr[j]=temp;

        if(start < j)
        partition(start , j-1 , start , arr);
        if(i<end)
        partition (i , end , i , arr);
    }
}

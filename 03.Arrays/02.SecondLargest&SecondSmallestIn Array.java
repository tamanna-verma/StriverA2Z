public class Solution {
    public static int[] getSecondOrderElements(int n, int []a) {
      // we need to write the code for second largest and second smallest element in the array 
      // we will be maintaining 4 pointers over here - largest , seocnd largest , smallest , second smallest 
      int largest =0;
      int secondlargest =-1;
      int smallest =Integer.MAX_VALUE;
      int secondsmallest =-1;

      for(int i=0;i<n;i++)
      {
          int val = a[i];

          if(val > largest){
               secondlargest = largest;
               largest = val;
          }
          else if (val != largest)
          {
              // THEN THERE WILL BE 3 CONDITIONS
              // if the val is greater than secondlargest or equal to largest or if secondlargest is -1
               if(secondlargest ==-1 || val > secondlargest)
               secondlargest = val;

          }
          if(val<smallest)
          {
               secondsmallest = smallest;
               smallest = val;
          }
             // THEN THERE WILL BE 3 CONDITIONS
              // if the val is smaller than secondsmallest or equal to smallest or if secondsmallest is -1
               
          else if (val != smallest){
             
           if(secondsmallest ==-1 || val < secondsmallest)
               secondsmallest = val;
          }
          
      }
          int ans[]=new int[2];
        if(secondsmallest== Integer.MAX_VALUE)  ans[1]=-1;
        else ans[1]= secondsmallest;
          if(secondlargest==0)  ans[0]=-1;
        else ans[0]= secondlargest;
          return ans;
    }
}

import java.util.ArrayList;

public class Solution 
{
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
       int low =0;
       int high =0;
       int ans=0;
        for(int i=0;i<boards.size();i++)
         {
          high+=boards.get(i);
         }  

        while(low<=high){
            int mid = low+((high-low)/2);
            if(possible(boards , mid , k)){
                high=mid-1;
                ans=mid;
            }
            else low=mid+1;
        }
         return ans;
         
   }
   public static boolean possible (ArrayList<Integer> boards , int area , int k){
       int painters=1;
       int currentarea=0;
       int n =boards.size();
       for(int i=0;i<n;i++){
           if(currentarea+boards.get(i)<=area){
              currentarea +=boards.get(i);
           }
           else {
               painters++;
               currentarea= boards.get(i);
               if(boards.get(i)>area|| painters>k)return false;
           }
       }
       return true;
   }
}

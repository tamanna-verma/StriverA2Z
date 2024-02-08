import java.util.ArrayList;
public class Solution {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if(n<m)return -1; //agar no. of books hi students se kam hai , to return -1 ;
       int low=0;
       int high = sumOfAllPages(arr);
       int ans=0;
       while(low<=high){
           int mid = low+ ((high-low)/2);
           if(possible(mid,arr,m)){
              ans=mid;
              high=mid-1;
           }
           else low=mid+1;
       }
       return ans;
    }
    public static boolean possible(int mid , ArrayList<Integer> arr  , int students  ){
        
       int n =arr.size();
       int studentcount=1;
       int pageCount=0;

       for(int i=0;i<n;i++){
           if(pageCount+arr.get(i)<=mid){
             pageCount+=arr.get(i);
           }
           else
           {
            studentcount+=1;
          
            if(studentcount>students || arr.get(i)>mid)return false;//agar student count hi jada hogye to return its not possible
              pageCount=arr.get(i);
           }
       }
          return true;
       
      
    }
    public static int sumOfAllPages(ArrayList<Integer> arr){
        int ans=0;
          for(int i=0;i<arr.size();i++){
           ans+=arr.get(i);
           }
           return ans;
       }
    
}

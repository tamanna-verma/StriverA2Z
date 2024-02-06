public class Solution {
    public static int NthRoot(int m, int n) {
        //we need to find n root of m 
       
	
		
	    int low = 0;
		int high = n;

		while(low<=high){
			int mid = low+((high-low)/2);
			 long val = 1;
            for(int i=0;i<m;i++){
                val*=mid;
                if(val>n)break;
            }
			if(val == n)return mid ;
			else if(val<n)low=mid+1;
			else high=mid-1;
		}
		return -1;
    }
}

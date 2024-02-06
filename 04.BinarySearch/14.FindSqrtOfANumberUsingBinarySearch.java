import java.util.* ;
import java.io.*; 

public class Solution {

  	//when till a certain point , answer is possible ,
  //and after a certain point , answer is not possible , then we apply , binary search , over there 
  //if mid * mid <n , it can be answer , so keep it in ans , move right , if equal return mid , otherwise move left 

	public static int sqrtN(long N) {
	
		long ans = N;
	    long low = 0;
		long high = N;

		while(low<=high){
			long mid = low+((high-low)/2);
			long val = mid*mid;
			if(val==N)return (int)mid ;
			else if (val<N)
			{
				ans=mid;
				low=mid+1;
			}else high=mid-1;
		}
		return (int)ans;
	}
}

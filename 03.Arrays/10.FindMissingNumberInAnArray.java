
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    
	    x=33
	    y=36
	    
	   // sum of a range from 1 to n =(n*n+1)/2
	   // sumactual - repeated + missing =n(n+1)/2
	    
	   // sum of squares of all elements = (n*n+1*2n+1) /6
	   
	   //x2-y2= (x+y)(x-y)
	    
		int [] arr= { 1,2,3,4,5,3,7,8};36 33
		int repeated=0;
		int missing=0;
		
		HashMap<Integer, Integer>map = new HashMap<>();
		for(int i=0;i<arr.length;i++){
		    int curr= arr[i];
		    int currfreq= map.getOrDefault(arr[i],0);
		    if (currfreq==1)repeated=curr;
		    map.put(curr , currfreq+1);
		}
		
		for(int i=0;i<arr.length;i++){
		    if(!map.containsKey(i+1))missing=i+1;
		}
	
		System.out.println(repeated+" "+missing);
	}
}


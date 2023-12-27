// way 1 - brute force - we will be using an extra array to put nonzeroes in that and then put rest all 0's in the extra array 


//way 2 - inplace replacing in the array
// we will be checking for the index where next zero is present and where nonzero is present , if the index for zero is less than index of nozero , 
// we will swap the values , if index for zero is greater than of non zero , we will simply move forward , increase index for nonzero 
// and not increase for zero because zero was already infront of  nonzero 

class Solution 
{
    public void moveZeroes(int[] nums) 
    {
      int zero =0;
      int nonzero =0;
        
        while(zero<nums.length && nonzero < nums.length){
            while(zero < nums.length && nums[zero]!=0)zero++;
            while( nonzero < nums.length && nums[nonzero]==0)nonzero++;
            
            if( zero < nonzero &&   zero <nums.length && nonzero<nums.length ) {
                int temp=nums[zero];
                nums[zero]=nums[nonzero];
                nums[nonzero]=temp;
            }else {
                nonzero++;
            }
            
        }
        
    }
}

// 0 1 0 3 12
// 1 3 12 0 0 
// 1 3 0 0

way 3 - we will first move all the nonzero infront using 2 pointers and then make rest all values as 0

class Solution 
{
    public void moveZeroes(int[] nums) 
    {
     
      int nonzero =0;
      int value=0;
        
        while( value<nums.length && nonzero < nums.length ){
            while(nonzero < nums.length && nums[nonzero]==0)nonzero++;
           
            if(value<=nonzero && nonzero<nums.length ) {
                nums[value]=nums[nonzero];
                value++;
                nonzero++;
           }
                
            if(!(nonzero<nums.length)){
                for(;value<nums.length;value++){
                    nums[value]=0;
                    
                }
            }
            
            
        }
        
    }
}
   
// 0 1 0 3 12  
// 1 3 12 0 0   
// 1 3 0 0

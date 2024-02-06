class Solution {
    public int shipWithinDays(int[] weights, int days) {
         int low= 0;
         int high=0;
         int sum=0;

         for(int i=0;i<weights.length;i++){
             low = Math.max(low, weights[i]);
             sum+=weights[i];
         }
        high= sum;
        //so we have min and max with us 
        int ans=0;
        while(low<=high){
            int midcapacity = low+ ((high-low)/2);
            
            if(getRounds(weights,midcapacity)<=days){
                ans=midcapacity;
                high=midcapacity-1;
            }
            else {
                low=midcapacity+1;

            }

        }
        return ans;
        
    }
    public int getRounds(int weights[], int midcapacity){

        int curr=midcapacity;
        int ans=0;
        int rounds=1;

        for(int i=0;i<weights.length;i++){
            if(curr>=weights[i])curr-=weights[i];
            else{
                rounds+=1;
                curr=midcapacity-weights[i];
            }
        }
        return rounds;
    }

}
//min capacity of ship will be of the max product otherwise we wont be able to take that product
// max capacity of ship can be the sum of weight of all products 

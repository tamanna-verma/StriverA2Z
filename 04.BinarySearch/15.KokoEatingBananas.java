class Solution {
    public int minEatingSpeed(int[] piles, int h)
    {
    // first we will find max banana koko can eat in an hour 
    int low=0;
    int high= findMax(piles);
   
    while(low<=high){
        int mid =low+ ((high-low)/2);
        int val= findtotalhours(piles , mid);
        if(val<=h){
           
           high=mid-1;
        }
        else low=mid+1;
    }
        return low;
    }

//initially low was at not pssible side and high was at possible side , 
//in the end , low will be at possible side always and high will be at not possible side
    public static int findtotalhours(int []piles , int bananaperhour){
        int total=0;
        for(int i=0;i<piles.length;i++)
        {
              total+=Math.ceil((double)piles[i]/(double)bananaperhour);
        }
        return total;
    }
    public static int findMax(int []piles){
        int max=0;
        for(int i=0;i<piles.length;i++)
        {
              max=Math.max(piles[i],max);
        }
        return max;
    }
}

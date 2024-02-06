class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        // HashSet<Integer> set= new HashSet<>();


        //k is no.of bouquets
        //m is no.of continuous flowers in a bouquet

        for(int i=0;i<bloomDay.length;i++){
            // set.add(bloomDay[i]);
            if(bloomDay[i]<min)min=bloomDay[i];
            if(bloomDay[i]>max)max=bloomDay[i];
        }

        int low = min;
        int high = max;
        int ans=-1;

        while(low<=high){
            int mid = low+ ((high-low)/2);
         
             if(getBouquets(bloomDay, mid,k)>=m){
                 ans=mid;
                 high=mid-1;
             }else{
                 low=mid+1;
             }
          }
            
        
       return ans;

    }
    public int getBouquets(int[] bloomDay , int mid, int size){

        int ans=0;
        int curr=0;
         for(int i=0;i<bloomDay.length;i++){
           if( bloomDay[i]<=mid) curr+=1;
           else
           {   
              ans+=(curr/size);
               curr=0;
           }
        }
      ans+=(curr/size);//agar else loop me nahi gye to jitna bhi curr hoga use divide krege
      return ans;
    }
}

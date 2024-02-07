class Solution {
    public static int solve(int n, int k, int[] stalls) {
      Arrays.sort(stalls);
      int low = 1;
      int high = stalls[n-1]-stalls[0];
      int ans = 0;
      while(low<=high){
          int mid= low+ ((high-low)/2);
          if(isPossible(mid , stalls , k)){
              ans=mid;
              low = mid+1;
          }
          else high=mid-1;
      }
      return ans;
    }

    public static boolean isPossible(int distance , int[]stalls , int cows){
        int i=0;
        int j=i+1; 
        int k = stalls.length;
        cows -= 1;
       while(j<k && cows>0){
           if(stalls[j]-stalls[i]>=distance){
               cows--;
               i=j;
           }
           j++;
       }
       if(cows<=0)return true;
       return false;
    }
}

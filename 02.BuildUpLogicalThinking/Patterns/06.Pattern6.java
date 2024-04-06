public class Solution {
    public static void nNumberTriangle(int n) {
    for(int i=0;i<n;i++){
        for(int j=1;j<=n-i;j++){
            System.out.print(j+" ");
          }
        System.out.println();
       }
    }
}

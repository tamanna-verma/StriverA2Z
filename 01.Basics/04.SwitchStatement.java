public class Solution {
    public static double areaSwitchCase(int ch, double []a) {
           switch(ch){
               case 1: 
                           return  a[0]*Math.PI*a[0];                    
               case 2:
                            return  a[0] * a[1] ;
                default:
                            return 0;               
           }
    }
}

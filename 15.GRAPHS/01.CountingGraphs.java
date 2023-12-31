public class Solution {
    public static int countingGraphs(int N) {
    // from n nodes , at max how many graphs can be made 
    // how many no. of ways can they be arranged
    // each node can be picked in 2 ways , joined with another one or not joined 
    // in a graph of n vertices /nodes , there canbe nc2 edges 
    //     we have 2 option now , we can have the edge or we cant 
    //    for 3 nodes= 2^3c2 different graphs

    return (int)Math.pow(2 , (int)((N * (N-1))/2));

      // 2 raised to the power nc2 , 
        

    }
}

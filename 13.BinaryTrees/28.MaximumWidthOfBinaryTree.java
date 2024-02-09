/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 class Pair{
   TreeNode node;
   int index;
   Pair(TreeNode node , int index){
       this.node = node;
       this.index=index;
   } 
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root){
        //We need to return the width of binary tree
        //we will be storing the index of the elements along with the element 
        // left = 2 *(i-1) +1;//wher i is the parent 
        // right = 2*(i-1)+2;
        //we are multiplying by i-1 to stop overflow 
        // otherwise we were multiplying from left = 2* i +0 , right = 2*i+1;

         Queue<Pair> queue = new LinkedList<>();
         queue.add(new Pair(root , 1));
         int maxwidth=0;

         while(!queue.isEmpty()){
          int size = queue.size();

          int smallestindex = queue.peek().index;
          int largestindex = 0;
           for(int i=0;i<size;i++){
              Pair popped =   queue.remove();
              int index = popped.index;
              if(i==size-1) largestindex = index;
             if(popped.node.left != null) queue.add(new Pair (popped.node.left , 2 * (index-1 ) +1));
             if(popped.node.right != null)queue.add(new Pair (popped.node.right , 2 * (index-1 ) +2));
           }
           if(largestindex-smallestindex + 1 > maxwidth)maxwidth=largestindex-smallestindex+1;
         }
         return maxwidth;
    }
}

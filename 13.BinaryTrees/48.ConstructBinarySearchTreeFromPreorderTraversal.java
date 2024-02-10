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
class Solution {
    int index=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return getRoot( Integer.MAX_VALUE , preorder);
    }
    public TreeNode getRoot(int bound , int [] preOrder){
      
      if(index>=preOrder.length || bound<preOrder[index])return null;
  
       int val = preOrder[index];
      TreeNode root = new TreeNode (val);
       index++;
      root.left = getRoot(val,preOrder);
      root.right  = getRoot( bound , preOrder);
      return root;
    }
}

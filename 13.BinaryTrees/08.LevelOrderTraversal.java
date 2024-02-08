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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //bfs 
        
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        List<List<Integer>> answer = new ArrayList<>();
        if(root==null)return answer;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> sa= new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.remove();
                sa.add(node.val);
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
           answer.add(sa);
        }
        return answer;
    }
}

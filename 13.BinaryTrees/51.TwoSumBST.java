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
//                   *
//               *
//           *
//  // inorder nikalo aur two sum lagado //sorted o(n) space
 // o(h) 
 //bst iterator - inorder 
 // stack -  6 7 
 //2 3 4 5 6 7

class Solution {

  static  Stack<TreeNode> left = new Stack <>();
  static  Stack<TreeNode> right = new Stack <>();

    public boolean findTarget(TreeNode root, int k)
    {
        //inorder has next
        //we are taking the left most element of inorder and rightest node of inorder
        if(root.left==null && root.right ==null){
             return false;
        }
       TreeNode temp = root;
       while(temp!=null){
           left.push(temp);
           temp=temp.left;
       }

       temp = root;
       while(temp!=null){
           right.push(temp);
           temp = temp.right;
       }

       int leftest = 0;
       int rightest = 0;
       if(hasNextLeft()){
         leftest = nodeFromLeft().val;
       }
      
      if(hasNextRight()){
         rightest = nodeFromRight().val;
       }
       
       while(leftest<=rightest){
         int sum =leftest+rightest; 
         if(sum==k && leftest!=rightest)return true;
         else if(sum<k){
             if(hasNextLeft()){
                 leftest = nodeFromLeft().val;
             }
             else return false;
         }
         else{
             if(hasNextRight()){
                 rightest = nodeFromRight().val;
             }
             else return false;
         }
       }
       return false;//stack is of o(H)
 
    }

    public static boolean hasNextLeft (){
        return left.isEmpty()==false;
    }

     public static boolean hasNextRight (){
        return right.isEmpty()==false;
    }


    public static TreeNode nodeFromLeft(){
        TreeNode root = left.pop();
       
        TreeNode temp = null;
        if(root.right!=null)
        {
        temp= root.right;
        }
        while(temp!=null){
            left.push(temp);
            temp=temp.left;
        }
        return root;
    }
     public static TreeNode nodeFromRight(){
        TreeNode root = right.pop();
        TreeNode temp = null;
        if(root.left!=null){
            temp= root.left;
        }
        while(temp!=null){
            right.push(temp);
            temp=temp.right;
        }
        return root;
    }

    
}

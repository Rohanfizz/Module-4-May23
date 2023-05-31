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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null){
            //check if im the special case  or not
            if(curr.left == null){
                //pre
                //in
                arr.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode rmn = curr.left;
                while(rmn.right != null && rmn.right!=curr) rmn = rmn.right;

                if(rmn.right == null){//there is no link present
                    //pre
                    rmn.right = curr; //establish link
                    curr = curr.left; // after pre move left
                }else{//there is a link
                    //in
                    arr.add(curr.val);
                    rmn.right = null;
                    curr = curr.right;
                }
            }
        }
        return arr;
    }
}







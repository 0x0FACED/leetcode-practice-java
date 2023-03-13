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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }


        return dfs(root, null, null);
    }

    public boolean dfs(TreeNode root, TreeNode minVal, TreeNode maxVal){
        if (root == null) {
            return true;
        }

        if (minVal != null && root.val <= minVal.val) {
            return false;
        }

        if (maxVal != null && root.val >= maxVal.val) {
            return false;
        }
        return dfs(root.left, minVal, root) 
                && dfs(root.right, root, maxVal);
    }
}

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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        TreeNode pointerLeft = root;
        TreeNode pointerRight = root;

        return dfs(pointerLeft.left, pointerRight.right);
    }

    public boolean dfs(TreeNode pointerLeft, TreeNode pointerRight){
        if(pointerLeft == null && pointerRight == null){
            return true;
        }
        if(pointerLeft == null || pointerRight == null || pointerLeft.val != pointerRight.val){
            return false;
        }

        return dfs(pointerLeft.left, pointerRight.right) && dfs(pointerLeft.right, pointerRight.left);
    }
}

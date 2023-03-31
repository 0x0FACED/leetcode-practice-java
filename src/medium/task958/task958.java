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
    public boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return false;
        }
        return dfs(root, 0);
    }
    private int targetDepth = 0;
    private int lastLevelFilled = 0;

    public boolean dfs(TreeNode root, int depth){
        if (root == null) {
            if (targetDepth == 0) {
                targetDepth = depth;
            } else if (depth == targetDepth - 1) {
                lastLevelFilled = 1;
            }
            return depth == targetDepth - lastLevelFilled;
        }
        return dfs(root.left, depth + 1) && dfs(root.right, depth + 1);
    }
}

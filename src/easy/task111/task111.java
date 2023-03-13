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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        return dfs(root);
    }

    public int dfs(TreeNode node){
        if (node == null) return 0;

        int left = minDepth(node.left) + 1;
        int right = minDepth(node.right) + 1;

        if (node.left == null) {
            return right;
        }
        if (node.right == null) {
            return left;
        }

        return Math.min(right, left);
    }
}

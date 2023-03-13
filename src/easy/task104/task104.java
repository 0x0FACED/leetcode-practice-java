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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return dfs(root, 0, 0);
    }

    public int dfs(TreeNode node, int maxDepth, int currDepth){
        if(node == null){
            return maxDepth;
        }
        ++currDepth;
        if(currDepth > maxDepth){
            maxDepth = currDepth;
        }

        return Math.max(dfs(node.left, maxDepth, currDepth), dfs(node.right, maxDepth, currDepth));
    }
}

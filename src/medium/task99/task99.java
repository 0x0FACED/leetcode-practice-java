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
    TreeNode first;
    TreeNode second;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        if (root == null) return;

        first = null;
        second = null;
        prev = null;

        dfs(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void dfs(TreeNode node){
        if (node == null) return;
        dfs(node.left);

        if (first == null && (prev == null || prev.val >= node.val)) {
            first = prev;
        }
        if (first != null && prev.val >= node.val) {
            second = node;
        }
        prev = node;
        dfs(node.right);
    }
}

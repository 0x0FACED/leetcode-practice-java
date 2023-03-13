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
        List<Integer> values = new ArrayList<>();
        TreeNode pointer = root;

        dfs(values, pointer);

        return values;
    }

    public void dfs(List<Integer> values, TreeNode node){
        if(node == null){
            return;
        }
        dfs(values, node.left);
        values.add(node.val);
        dfs(values, node.right);
    }
}

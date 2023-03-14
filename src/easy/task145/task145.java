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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        dfs(root, values);
        return values;
    }

    public void dfs(TreeNode node,  List<Integer> values){
        if(node == null){
            return;
        }
        dfs(node.left, values);
        dfs(node.right, values);
        values.add(node.val);
    }
}

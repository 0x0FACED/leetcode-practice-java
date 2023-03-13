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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        } else if(p == null && q != null){
            return false;
        } else if(p != null && q == null){
            return false;
        }

        return dfs(p, q);
    }

    public boolean dfs(TreeNode pNode, TreeNode qNode){
        if(pNode == null && qNode == null){
            return true;
        }
        if(pNode == null && qNode != null){
            return false;
        }
        if(pNode != null && qNode == null){
            return false;
        }

        if(pNode.val != qNode.val){
            return false;
        }

        return dfs(pNode.left, qNode.left) && dfs(pNode.right, qNode.right);
    }
}

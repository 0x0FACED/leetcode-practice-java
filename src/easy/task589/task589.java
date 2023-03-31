/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> values = new ArrayList<>();
        backtrack(root, values);
        return values;
    }

    public void backtrack(Node root, List<Integer> values){
        if(root == null){
            return;
        }
        values.add(root.val);
        for(Node curr : root.children){
            backtrack(curr, values);
        }
    }
}

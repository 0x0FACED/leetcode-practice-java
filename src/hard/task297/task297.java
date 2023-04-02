/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    Queue<TreeNode> _queue;
    List<Integer> _values;

    // Encodes a tree to a single string.
    // serialize() uses a queue to tree traversal PREORDER NLR (node-left-right)
    public String serialize(TreeNode root) {
        _queue = new LinkedList<>();
        _queue.offer(root);
        _values = new ArrayList<>();
        while(_queue.size() != 0){
            TreeNode curr = _queue.poll();
            if(curr != null){
                _values.add(curr.val);
                _queue.offer(curr.left);
                _queue.offer(curr.right);
            } else _values.add(null);
        }
        for(int i = _values.size() - 1; i >= 0; --i){
            if(_values.get(_values.size() - 1) == null) 
                _values.remove(_values.size() - 1);
            else break;
        }
        return _values.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;

        data = data.substring(1, data.length() - 1);
        String[] strValues = data.split(", ");
        TreeNode root = null;
        root = new TreeNode(Integer.parseInt(strValues[0]));
        Queue<Pair> stack = new LinkedList<>();
        stack.offer(new Pair(root, (short)0));
        int index = 1;
        while(index < strValues.length){
            TreeNode currNode = null;
            String currStr = strValues[index++];
            if(!currStr.equals("null")){
                currNode = new TreeNode(Integer.parseInt(currStr));
            }
            Pair pair = stack.peek();
            TreeNode parent = pair._node;
            if(pair._state == 0){
                parent.left = currNode;
                ++pair._state;
            } else if(pair._state == 1){
                parent.right = currNode;
                stack.remove();
            }

            if(currNode != null){
                pair = new Pair(currNode, (short)0);
                stack.offer(pair);
            }
        }
        return root;
    }
}

class Pair{
    TreeNode _node;
    short _state;
    public Pair(TreeNode node, short state){
        _node = node;
        _state = state;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

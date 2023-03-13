/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    ListNode root;
    public Solution(ListNode head) {
        root = head;
    }
    
    public int getRandom() {
        ListNode node = root;
        int counter = 0;
        int result = 0;
        while(node != null){
            ++counter;
            if((int) (Math.random() * counter) == 0){
                result = node.val;
            }
            node = node.next;
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

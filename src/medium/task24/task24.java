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
    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode curr = result;

        while(head != null){
            int value1 = head.val;
            head = head.next;
            if(head != null){
                curr.next = new ListNode(head.val);
                curr = curr.next;
                curr.next = new ListNode(value1);
                curr = curr.next;
                head = head.next;
            } else {
                curr.next = new ListNode(value1);
                curr = curr.next;
            }
            
        }
        return result.next;
    }
}

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1){
            return head;
        }
        ListNode result = new ListNode(0);
        ListNode curr = result;

        int[] values = new int[k];
        int counter = 0;
        while(true){
            values[counter++] = head.val;
            head = head.next;
            if(counter == k){
                for(int i = k - 1; i >= 0; --i){
                    curr.next = new ListNode(values[i]);
                    curr = curr.next;
                }
                counter = 0;
                values = new int[k];
            }
            if(head == null){
                for(int i = 0; i < counter; ++i){
                    curr.next = new ListNode(values[i]);
                    curr = curr.next;
                }
                break;
            }
        }

        return result.next;
    }
}

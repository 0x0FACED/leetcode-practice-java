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
    public ListNode sortList(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while(head != null){
            values.add(head.val);
            head = head.next;
        }

        values.sort(Comparator.naturalOrder());
        ListNode res = new ListNode(0);
        ListNode pointer = res;
        for(Integer val : values){
            pointer.next = new ListNode(val);
            pointer = pointer.next;

        }
        return res.next;
    }
}

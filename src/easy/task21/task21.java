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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode tempResult = result;

        while(list1 != null && list2 != null){
            if (list1.val <= list2.val) {
                tempResult.next = list1;
                list1 = list1.next;
            } else {
                tempResult.next = list2;
                list2 = list2.next;
            }
            tempResult = tempResult.next;
        }

        tempResult.next = list1 == null ? list2 : list1;
        return result.next;
    }
}

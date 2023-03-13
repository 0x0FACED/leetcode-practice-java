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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode list = new ListNode(0);
        ListNode listRes = list;
        ListNode tempList = head;
        int length = 1;
        while(true){
            if(tempList.next != null){
                length++;
                
                tempList = tempList.next;
            } else {
                break;
            }
        }
        for(int i = 0; i < length; ++i){
            if(i == length - n){
                System.out.println("IN IF" + head.val);
            } else {
                System.out.println(head.val);
                list.next = new ListNode(head.val);
                list = list.next;
            }
            head = head.next;
        }
        System.out.println(length);

        return listRes.next;
    }
}

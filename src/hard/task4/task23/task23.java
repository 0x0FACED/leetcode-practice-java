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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null){
            return new ListNode();
        }
        
        ListNode head = new ListNode(0);
        ListNode curr = head;


        List<Integer> values = new ArrayList<>();
        while(true){
            int counter = 0;
            for(int i = 0; i < lists.length; ++i){
                if(lists[i] != null){
                    values.add(lists[i].val);
                    lists[i] = lists[i].next;
                } else {
                    ++counter;
                }
                //System.out.println(values);
            }
            if(counter == lists.length){
                break;
            }
        }
        values.sort(Comparator.naturalOrder());
        for(Integer i : values){
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return head.next;
    }
}

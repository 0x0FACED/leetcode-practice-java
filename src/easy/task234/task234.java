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

// Method 1 using Stack
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode leftPointer = head;
        Stack<Integer> stack = new Stack<>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }

        while(!stack.empty()){
            if(stack.pop() != leftPointer.val){
                return false;
            }
            leftPointer = leftPointer.next;
        }
        return true;
    }
}

// Method 2 using List to store values

class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>();

        while(head != null){
            values.add(head.val);
            head = head.next;
        }

        int left = 0;
        int right = values.size() - 1;
        while(left < right){
            if(values.get(left) != values.get(right)){
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}

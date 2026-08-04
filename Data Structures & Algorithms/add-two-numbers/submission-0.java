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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        ListNode prev = dummyNode;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            prev.next = new ListNode(sum%10);
            carry = sum/10;
            prev = prev.next;
        }
        
        // add remaining items if any left
        while (l1 != null) {
            int sum = carry;
            sum += l1.val;
            l1 = l1.next;
            prev.next = new ListNode(sum%10);
            carry = sum/10;
            prev = prev.next;
        }

        while (l2 != null) {
            int sum = carry;
            sum += l2.val;
            l2 = l2.next;
            prev.next = new ListNode(sum%10);
            carry = sum/10;
            prev = prev.next;
        }

        // if carry remains, add a new node for it
        if (carry != 0) {
            prev.next = new ListNode(carry);
        }
        
        return dummyNode.next;
    }
}

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
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode head = null;
        ListNode last = head;

        while (head1 != null && head2 != null) {
            ListNode curr;
            if (head1.val <= head2.val) {
                curr = head1;
                head1 = head1.next;
            } else {
                curr = head2;
                head2 = head2.next;
            }
            if (head == null) {
                head = curr;
            }
            if (last != null) {
                last.next = curr;
            }
            last = curr;
        }
        
        if (head1 != null) {
            if (head == null) {
                head = head1;
            } else {
                last.next = head1;
            }
        }
        
        if (head2 != null) {
            if (head == null) {
                head = head2;
            } else {
                last.next = head2;
            }
        }
        
        return head;
    }
}
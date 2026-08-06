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
        ListNode prev = null;
        ListNode curr = null;
        ListNode head = null;

        while (head1 != null && head2 != null) {
            
            // choose curr based on val comparison
            if (head1.val <= head2.val) {
                curr = head1;
                head1 = head1.next;
            } else {
                curr = head2;
                head2 = head2.next;
            }
            
            // now update prev.next and head
            if (prev != null) {
                prev.next = curr;
            } else {
                head = curr;
            }
            
            // update prev to curr
            prev = curr;
        }
        
        // check if head1 remains
        if (head1 != null) {
            if (prev != null) {
                prev.next = head1;
            } else {
                head = head1;
            }
        }
        
        if (head2 != null) {
            if (prev != null) {
                prev.next = head2;
            } else {
                head = head2;
            }
        }
        
        return head;
    }
}
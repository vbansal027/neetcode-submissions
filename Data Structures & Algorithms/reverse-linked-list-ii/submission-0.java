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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head != null && head.next != null && (right-left > 0)) {
            ListNode prev = null;
            ListNode curr = head;
            ListNode next = head.next;

            // first we move curr to left node. Since q is using 1 indexing, we move curr ahead by left-1 steps
            for (int i=0; i<left-1; i++) {
                prev = curr;
                curr = next;
                next = (next != null) ? next.next : next;
            }
            
            // at this point curr is at left, and prev is at left-1
            // curr will be our tail after reversal and left-1 will be the node preceeding head
            // so we save their references before we start reversal
            ListNode pre_head = prev;
            ListNode rev_tail = curr;
            
            // now we start reversing from curr (left) till right => (right-left+1) nodes
            for (int i=0; i<(right-left+1); i++) {
                curr.next = prev;
                prev = curr;
                curr = next;
                next = (next != null) ? (next.next) : next;
            }
            
            // at this point prev is now pointing to the head of the reversed part
            // curr is pointing to the node next to the (right)
            ListNode rev_head = prev;
            
            // we update the pre_head node's next pointer to point to the new head
            // but if it is null => left was 1 => we need to update the head
            if (pre_head != null) {
                pre_head.next = rev_head;
            } else {
                head = rev_head;
            }
            
            // update the rev_tail's next to point to (right+1) element
            rev_tail.next = curr;
        }

        return head;
    }
}
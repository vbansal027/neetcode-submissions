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

    public ListNode reverseList(ListNode head) {
        head = (head == null) ? (head) : reversHelper(head, null);
        return head;
    }

    private ListNode reversHelper(ListNode current, ListNode prev) {
        if (current.next == null) {
            // base case, last node
            // update the next pointer to previous and return itself as the head
            current.next = prev;
            return current;
        }
        
        // get new head from the list ahead
        ListNode head = reversHelper(current.next, current);
        // update current node's next pointer to point to prev
        current.next = prev;
        // return whatever new head received from list ahead
        return head;
    }
}

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
    public void reorderList(ListNode head) {
        // first we find the mid of the list
        // then we reverse the last half of it
        // then we combine them in order

        ListNode mid = getMid(head);
        // reverse from mid
        mid = reverseRec(mid);

        while (mid.next != null) {

            ListNode temp = head.next;
            head.next = mid;
            head = temp;

            temp = mid.next;
            mid.next = head;
            mid = temp;
        }
    }

    private ListNode getMid(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode reverseRec (ListNode head) {
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

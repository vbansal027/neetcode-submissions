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
        if (head == null) {
            return head;
        }
        
        // init two pointers with a gap of n between them
        ListNode p1 = head;
        ListNode p2 = head;
        while (n > 0 && p2!=null) {
            p2 = p2.next;
            n--;
        }
        // if n is not exhausted => n > size of list
        if (n != 0) {
            throw new IndexOutOfBoundsException("input \"n\" is be greater than size of the list");
        }
        // if p2 == null => head (1st element from start) needs to be removed
        if (p2 == null) {
            head = head.next;
            return head;
        }
        // now move both p1 and p2 ahead till p2 reaches last node
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // at this point p1.next is the node that needs to be deleted
        p1.next = p1.next.next;
        return head;
    }
}

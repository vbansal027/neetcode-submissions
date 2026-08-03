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
    public boolean hasCycle(ListNode head) {
        
        ListNode s = head;
        ListNode f = head;

        do {
            s = (s!= null) ? s.next : null;
            f = (f != null && f.next!=null) ? (f.next.next) : null;
        } while (s != f);

        return (s != null);
    }
}

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head != null && head.next != null && k>1) {
            
            ListNode prev = null;
            ListNode curr = head;
            ListNode p1 = head;
            ListNode p2 = head;
            int window = k;
            // maintain a fixed window of k links between p1 and p2 and keep reversing in between
            
            while (true) {
                window = k;
                while (p2 != null && (window--) > 0) {
                    p2 = p2.next;
                }
                if (window > 0) {
                    return head;
                }
                
                ListNode head_r = reverseListTill(p1, p2);
                
                if (prev == null) {
                    head = head_r;
                } else {
                    prev.next = head_r;
                }
                
                // p1 which was initially the start of the list, is now the tail of the list that's been reversed
                // so it becomes the next prev, also its next need to point the next p1
                prev = p1;
                prev.next = p2;
                p1 = p2;
            }
        }

        return head;
    }

    private ListNode reverseListTill (ListNode head, ListNode delimiter) {

        if (head != null && head.next != null) {
            ListNode prev = null;
            ListNode curr = head;
            ListNode next = head.next;

            while (curr != delimiter) {
                curr.next = prev;
                prev = curr;
                curr = next;
                next = (next != null) ? next.next : null;
            }

            head = prev;
        }

        return head;
    }
}

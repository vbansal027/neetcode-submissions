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
    public boolean isPalindrome(ListNode head) {
        if (head != null && head.next != null) {

            // First find the mid of the LL using fast and slow ptr approach
            ListNode p1 = head;
            ListNode p2 = head;
            do {
                p1 = p1.next;
                p2 = p2.next.next;
            } while (p2 != null && p2.next != null);

            // at this point p1 is the mid and we need to reverse the list from p1
            // keep a reference to p1 here for breaking out of the palindrome check loop
            ListNode mid = p1;

            // reverse list from p1 to end
            ListNode prev = null;
            ListNode next = p1.next;
            while (p1 != null) {
                p1.next = prev;
                prev = p1;
                p1 = next;
                next = (next != null) ? next.next : next;
            }
            // prev is the head of the reversed list
            ListNode rev_head = prev;

            // now move both heads in comparison
            // re-using p2
            p2 = head;
            while (p2 != mid) {
                if (p2.val != rev_head.val) {
                    return false;
                }
                p2 = p2.next;
                rev_head = rev_head.next;
            }
        }

        return true;
    }
}
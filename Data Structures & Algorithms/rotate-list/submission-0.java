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
    public ListNode rotateRight(ListNode head, int k) {
        if (head != null && head.next != null && k > 0) {
            // calculate length of ll and tail pointer
            ListNode tail = null;
            ListNode temp = head;
            int length = 0;
            while (temp != null) {
                tail = temp;
                length++;
                temp = temp.next;
            }
            
            // re-calibrate k to modulo of length of list
            k %= length;
            
            if (k > 0) {
                temp = head;
                for (int i=0; i<(length-k-1); i++) { // find the (length-k)th node
                    temp = temp.next;
                }
                tail.next = head;
                head = temp.next;
                temp.next = null;
            }
        }
        
        return head;
    }
}
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode tail = null;
        // create a priority queue and implement comparator to 
        // prioritize min val element at top
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        
        // push all heads of the LLs to heap that are non-null
        for (ListNode node : lists) {
            if (node != null) {
                // each add take O(log(k)) time, where k is the size of the heap at the time of addition
                minHeap.add(node);
            }
        }
        
        // now pop from heap and add to head till the heap is not empty
        while (!minHeap.isEmpty()) {
            
            // each poll() operation take O(log(k)) time, where k is the size of the heap at the time of polling
            ListNode curr = minHeap.poll();
            
            // update the list formed so far
            if (head == null) {
                head = curr;
            } else {
                tail.next = curr;
            }
            tail = curr;
            
            // if the last polled element's original list has any element, add that to the heap now
            if (tail.next != null) {
                // O(log(k))
                minHeap.add(tail.next);
            }
        }
        
        return head;
    }
}

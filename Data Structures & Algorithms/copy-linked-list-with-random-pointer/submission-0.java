/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // empty list case
        if (head == null) {
            return null;
        }

        Map<Node, Node> hashMap = new HashMap<>();
        Node temp = head;
        Node newHead = null;
        Node last = null;
        
        // prepare hash-map
        while (temp != null) {
            Node current = new Node(temp.val);
            hashMap.put(temp, current);
            if (last == null) {
                newHead = current;
            } else {
                last.next = current;
            }
            last = current;
            temp = temp.next;
        }
        
        last = newHead;
        temp = head;
        while (temp != null) {
            last.random = (temp.random != null) ? hashMap.get(temp.random) : null;
            temp = temp.next;
            last = last.next;
        }
        
        return newHead;
    }
}

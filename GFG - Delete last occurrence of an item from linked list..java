class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    public static Node deleteLastOccurrence(Node head, int key) {
        if (head == null) return null;

        Node last = null;         
        Node lastPrev = null;     
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            if (curr.data == key) {
                last = curr;
                lastPrev = prev;
            }
            prev = curr;
            curr = curr.next;
        }

       
        if (last == null) return head;

        // If last occurrence is head node
        if (lastPrev == null) {
            head = head.next;
        } else {
            lastPrev.next = last.next;  // remove last occurrence
        }

        return head;
    }
}

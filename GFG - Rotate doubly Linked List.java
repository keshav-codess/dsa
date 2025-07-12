class Solution {
    // Function to rotate the doubly linked list counter-clockwise by P nodes
    static Node rotateDLL(Node head, int P) {
        if (head == null || P == 0) return head;

        Node current = head;
        int count = 1;

        // Step 1: Traverse to the P-th node
        while (count < P && current != null) {
            current = current.next;
            count++;
        }

        // If current is null, P >= number of nodes — invalid input
        if (current == null || current.next == null) return head;

        Node newHead = current.next;

        // Step 2: Break the list at P-th node
        newHead.prev = null;
        current.next = null;

        // Step 3: Traverse to the last node of the new list
        Node tail = newHead;
        while (tail.next != null) {
            tail = tail.next;
        }

        // Step 4: Connect tail to old head
        tail.next = head;
        head.prev = tail;

        // Step 5: Return new head
        return newHead;
    }
}

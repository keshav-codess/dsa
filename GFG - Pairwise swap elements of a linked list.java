/* node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    // Function to pairwise swap elements of a linked list.
    // It should returns head of the modified list
    public Node pairwiseSwap(Node head) {
        // code here
   // If the list is empty or has only one node
        if (head == null || head.next == null)
            return head;

        Node prev = null;
        Node curr = head;
        head = head.next; 

        while (curr != null && curr.next != null) {
            Node next = curr.next;
            Node temp = next.next;

           
            next.next = curr;
            curr.next = temp;

            if (prev != null) {
                prev.next = next;
            }

            prev = curr;
            curr = temp;
        }

        return head;
    }
}

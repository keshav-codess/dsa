/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    public static Node findIntersection(Node head1, Node head2) {
        Node dummy = new Node(0);  
        Node tail = dummy;

        Node p1 = head1;
        Node p2 = head2;

        while (p1 != null && p2 != null) {
            if (p1.data < p2.data) {
                p1 = p1.next;
            } 
            
            else if (p1.data > p2.data) {
                p2 = p2.next;
            }
            
            else {
                // match found
                tail.next = new Node(p1.data);
                tail = tail.next;

                p1 = p1.next;
                p2 = p2.next;
            }
        }

        return dummy.next;
    }
}

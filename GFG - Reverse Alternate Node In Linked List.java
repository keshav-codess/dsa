/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/

class Solution {
    public Node rearrange(Node head) {
        if (head == null || head.next == null) return head;

        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        // extract alternate nodes
        while (even != null && even.next != null) {
            odd.next = even.next;     
            odd = odd.next;           
            even.next = odd.next;     
            even = even.next;         
        }

        Node prev = null, curr = evenHead, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        odd.next = prev;

        return head;
    }
}

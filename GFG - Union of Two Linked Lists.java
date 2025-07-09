
/*
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Solution {
    public static Node findUnion(Node head1, Node head2) {
        List<Integer> list = new ArrayList<>();

        Node temp = head1;
        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        temp = head2;
        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        // sort the list
        Collections.sort(list);

        Node dummy = new Node(0);
        Node current = dummy;

        int prev = -1;  
        for (int val : list) {
            if (val != prev) {
                current.next = new Node(val);
                current = current.next;
                prev = val;
            }
        }

        return dummy.next;
    }
}

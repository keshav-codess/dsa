/*
delete n nodes after m nodes
The input list will have at least one element
Node is defined as
  class Node
  {
      int data;
      Node next;
      Node(int data)
      {
          this.data = data;
          this.next = null;
      }
  }
*/
class Solution {
    static void linkdelete(Node head, int M, int N) {
        Node curr = head;

        while (curr != null) {
            // 🔁 Keep M nodes (move M - 1 times)
            for (int i = 1; i < M && curr != null; i++) {
                curr = curr.next;
            }

            // If list ended
            if (curr == null || curr.next == null) return;

            // Delete next N nodes
            Node temp = curr.next;
            for (int i = 0; i < N && temp != null; i++) {
                temp = temp.next;
            }

            // Link current node to the node after deleted nodes
            curr.next = temp;

            // Move curr to temp to repeat process
            curr = temp;
        }
    }
}



    

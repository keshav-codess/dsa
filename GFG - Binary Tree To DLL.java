/* class Node
class Node
{
    Node left, right;
    int data;

    Node(int d)
    {
        data = d;
        left = right = null;
    }

}*/

// This function should return head to the DLL

class Solution {
    // Function to convert binary tree to doubly linked list and return it.
     Node prev = null;
    Node head = null;

    Node bToDLL(Node root) {
        if (root == null) return null;

        bToDLL(root.left);

        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        bToDLL(root.right);

        return head;
    }
}

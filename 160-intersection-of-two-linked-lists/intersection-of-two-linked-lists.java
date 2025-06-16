/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // Approach 2: Time Complexity O(N), Space Complexity O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // If either list is empty, there can be no intersection
        if (headA == null || headB == null) {
            return null;
        }

        // Two pointers starting at the heads of the lists
        ListNode a = headA;
        ListNode b = headB;

        // Loop until both pointers are equal (either at intersection node or null)
        while (a != b) {
            // If 'a' reaches the end, start again from headB
            // Otherwise, move to the next node
            a = (a == null) ? headB : a.next;

            // If 'b' reaches the end, start again from headA
            // Otherwise, move to the next node
            b = (b == null) ? headA : b.next;
        }

        // Either both meet at intersection node, or both become null (no intersection)
        return a;
    }


    // Time Complexity: O(N), Space Complexity: O(N)
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        // Maintain a set to store nodes of List B
        Set<ListNode> set = new HashSet<>();

        // Add all nodes of List B to the set
        while (headB != null) {
            set.add(headB);
            headB = headB.next;
        }

        // Traverse List A and check if any node is in the set
        while (headA != null) {
            if (set.contains(headA)) {
                return headA; // Here we return the intersection node
            }
            headA = headA.next;
        }

        return null; // No intersection found
    }
}

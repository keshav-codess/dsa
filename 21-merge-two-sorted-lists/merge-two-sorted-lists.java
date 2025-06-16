/** 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify the merging process
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Traverse both lists and compare current nodes
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;     // Attach list1's node
                list1 = list1.next;       // Move list1 ahead
            } else {
                current.next = list2;     // Attach list2's node
                list2 = list2.next;       // Move list2 ahead
            }
            current = current.next;       // Move current pointer ahead
        }

        // Attach any remaining nodes from list1 or list2
        current.next = (list1 != null) ? list1 : list2;

        // Return the merged list starting from dummy.next
        return dummy.next;
    }
}

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode temp = head;

        // Step 1: Count total nodes
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Step 2: Find position to remove from start
        int reach = count - n;

        // Step 3: If removing the head
        if (reach == 0) {
            return head.next;
        }

        temp = head;
        for (int i = 1; i < reach; i++) {
            temp = temp.next;
        }
        
        temp.next = temp.next.next;

        return head;
    }
}

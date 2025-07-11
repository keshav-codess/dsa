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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode curr = head;
        int length = 1;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        // connect tail to head (make it circular)
        curr.next = head;

        int stepsToNewTail = length - (k % length);
        ListNode newTail = head;
        for (int i = 0; i < stepsToNewTail - 1; i++) {
            newTail = newTail.next;
        }

        // break the ring
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}

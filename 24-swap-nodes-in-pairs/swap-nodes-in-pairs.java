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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // After swap there would be a new head
        ListNode newHead = head.next;
        ListNode current = head;
        ListNode prev = null; // track the last node of the prev swapped pair

        while (current != null && current.next != null) {
            // Find out the pairs for swapping
            ListNode first = current;
            ListNode second = current.next;
            ListNode nextPair = second.next;

            // Swap happens here
            second.next = first;
            first.next = nextPair;

            if (prev != null) {
                prev.next = second;
            }

            // Update previous and current for next pair
            prev = first;
            current = nextPair;
        }

        return newHead;
        
    }
}
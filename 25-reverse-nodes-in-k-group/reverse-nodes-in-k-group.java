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
    public ListNode reverseKGroup(ListNode head, int k) {
        // check if there are at least k nodes left
        ListNode temp = head;
        int count = 0;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        // less than k nodes, no reversal
        if (count < k) return head;

        // reverse first k nodes
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int i = 0;

        while (i < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        // recursively call on the remaining list
        head.next = reverseKGroup(curr, k);

        return prev;
    }
}

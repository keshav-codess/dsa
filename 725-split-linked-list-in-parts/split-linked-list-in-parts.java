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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] parts = new ListNode[k];
        
        int totalLength = 0;
        ListNode curr = head;
        while (curr != null) {
            totalLength++;
            curr = curr.next;
        }
        
        int baseSize = totalLength / k;
        int extra = totalLength % k;
        
        // split into parts
        curr = head;
        for (int i = 0; i < k; i++) {
            ListNode partHead = curr;
            int partSize = baseSize + (i < extra ? 1 : 0);
            
            for (int j = 0; j < partSize - 1; j++) {
                if (curr != null) curr = curr.next;
            }
            
            if (curr != null) {
                ListNode next = curr.next;
                curr.next = null;
                curr = next;
            }
            
            parts[i] = partHead;
        }
        
        return parts;
    }
}

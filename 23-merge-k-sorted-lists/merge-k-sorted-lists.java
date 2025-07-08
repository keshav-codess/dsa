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
import java.util.PriorityQueue;

class Solution {

    // Function to merge two sorted linked lists (used in simple approach)
    public ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }

        return dummy.next;
    }

    // Brute-force: merge one by one
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoSortedLists(result, lists[i]);
        }

        return result;
    }





    // Optimized: Min Heap / Priority Queue

    public ListNode mergeKListsOptimized(ListNode[] lists) {
        // Min heap to keep the smallest node on top
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add head of all k lists to the min heap
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        // Dummy head for the result list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Until heap is empty
        while (!pq.isEmpty()) {
            // Extract the node with the smallest value
            ListNode minNode = pq.poll();

            // Add it to the result list
            tail.next = minNode;
            tail = tail.next;

            // If the list has more nodes, add the next one to heap
            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }

        return dummy.next;
    }
}

/*
 * MergeKSortedLists2
 *
 * Approach:
 * Use a min-heap (PriorityQueue) that stores the current head node of each list.
 * Initialize the heap with the first node of every non-empty list. Repeatedly
 * poll the smallest node from the heap, append it to the result list, and if
 * the polled node has a next node, push that next node into the heap.
 *
 * Time complexity: O(N log k), where N is the total number of nodes across all
 * lists and k is the number of lists. Each node is pushed/popped at most once.
 * Space complexity: O(k) for the heap.
 *
 * LeetCode: https://leetcode.com/problems/merge-k-sorted-lists/
 */

import java.util.PriorityQueue;
import java.util.Comparator;

public class MergeKSortedLists2 {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode current = dummy;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        for (ListNode head : lists) {
            if (head != null)
                priorityQueue.add(head);
        }

        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            current.next = node;
            current= current.next;
            if (node.next != null) {
                priorityQueue.add(node.next);
            }
        }

        return dummy.next;
    }
}

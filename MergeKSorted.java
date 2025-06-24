import java.util.*;

/*
Time Complexity: O(N log K) where N is the total number of nodes across all linked lists and K is the number of linked lists.
Space Complexity: O(K) for the priority queue to store the heads of the linked lists.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Intuition: We can use a min-heap (priority queue) to efficiently merge the k sorted linked lists. We start by adding the head of each linked list to the min-heap. Then, we repeatedly extract the minimum element from the heap, which will be the next node in the merged list, and add its next node back to the heap if it exists.
*/

public class MergeKSorted {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode head : lists) {
            if (head != null) {
                minHeap.add(head);
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            current.next = min;

            if (min.next != null) {
                minHeap.add(min.next);
            }
            current = current.next;
        }

        return dummy.next;
    }
}

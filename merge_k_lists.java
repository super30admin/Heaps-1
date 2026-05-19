// Time Complexity : O(n log k) where n is the total number of nodes across all linked lists and k is the number of lists
// Space Complexity : O(k) for storing at most one node from each list in the Min Heap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use a Min Heap to always retrieve the smallest node among the current heads of all k sorted linked lists.
// Initially, we add the head node of every non-empty linked list into the heap.
// Each time we remove the smallest node, we attach it to the merged list and insert its next node into the heap if it exists.

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        // min heap based on node value
        PriorityQueue<ListNode> pq =
            new PriorityQueue<>(
                (ListNode a, ListNode b) -> a.val - b.val
            );

        // add head of each list
        for (ListNode head : lists) {

            if (head != null) {
                pq.add(head);
            }
        }

        ListNode dummy = new ListNode(-1);

        ListNode curr = dummy;

        while (!pq.isEmpty()) {

            // get smallest node
            ListNode min = pq.poll();

            // attach node to merged list
            curr.next = min;

            curr = curr.next;

            // add next node from same list
            if (min.next != null) {
                pq.add(min.next);
            }
        }

        return dummy.next;
    }
}
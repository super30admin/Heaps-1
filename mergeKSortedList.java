/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// Time Complexity : O(nklogk), k is the number of list and n is the size of the
// list
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three
// sentences only
/*
 * Maintaina a minHeap to store all lists in the queue.
 * We get the minimum value and append it to the result and if the next element
 * for the list is not emepty add it to the queue,
 * Run this till the queue is not empty
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(-1);
        ListNode current = result;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        while (!pq.isEmpty()) {
            ListNode minimum = pq.poll();
            current.next = minimum;
            current = current.next;

            if (minimum.next != null) {
                pq.add(minimum.next);
            }
        }

        return result.next;
    }
}
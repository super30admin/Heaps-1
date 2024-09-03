// Problem 23. Merge k Sorted Lists
// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

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
    public ListNode mergeKLists(ListNode[] lists) {
        // base case
        if (lists == null || lists.length == 0) {
            return null;
        }
        // min-heap (priority queue)
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        // Add the head of each list to the min-heap
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        // dummy node to act as the head of the result list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        // extract smallest element from the heap and add to result
        while (!pq.isEmpty()) {
            ListNode smallestNode = pq.poll();
            current.next = smallestNode;
            current = current.next;
            if (smallestNode.next != null) {
                pq.add(smallestNode.next);
            }
        }
        return dummy.next;
    }
}

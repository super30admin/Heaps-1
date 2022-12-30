// Merge k Sorted Lists
// Time Complexity : O(n logK)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach
// will apply min heap. first insert all the heads of the list into the priority queue(heapify).
// remove the min element. the element which gave the min value, go to it's next element and add that into the priority queue
// repeat until priority queue is not empty and return the result pointing to its next.

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
        ListNode result = new ListNode(-1);
        ListNode curr = result;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode head : lists) {
            if(head != null) {
                pq.add(head);
            }
        }
        while(!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null) {
                pq.add(min.next);
            }
        }
        return result.next;
    }
}
// Time Complexity : O(n * k * log(k)) --> where n is the average size of linked list and k is the size of heap or numbers of linked list inside input array
// Space Complexity : O(k)
// Did this code successfully run on Leetcode (23):
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // edge case
        if (lists == null || lists.length == 0) return null;
        
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for (ListNode head : lists) {
            if (head != null) pq.add(head);
        }
        
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            dummy.next = min;
            dummy = dummy.next;
            if (min.next != null) {
                min = min.next;
                pq.add(min);
            }
        }
        
        return result.next;
    }
}
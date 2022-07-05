// Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)

// Time Complexity: O(n * log k)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: Took reference from lecture

class Solution {
   
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(ListNode head: lists) {
            if(head != null) {
                pq.add(head);
            }
        }
        ListNode res = new ListNode(-1);
        ListNode curr = res;
        while(!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null) {
                pq.add(min.next);
            }
        }
        return res.next;
    }
}
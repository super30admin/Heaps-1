// Time Complexity : O(nk * logk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


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
        
        if(lists == null) return null;
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode result =  dummy;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for(ListNode head: lists) {
            if(head != null)
                pq.add(head);
        }
        
        while(!pq.isEmpty()) {
            ListNode curr = pq.poll();
            dummy.next = curr;
            if(curr.next != null) {
                pq.add(curr.next);
            }
            dummy = curr;
        }
        return result.next;
        
    }
}
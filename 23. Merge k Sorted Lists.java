/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Time Complexity: O()
// Space Complexity: O()
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

//Start from 1st node then add 1st element other node, use min heap, when the element polls the next element of polled elements gets added to priority queue. If the next element is null then, min heaps root gets polled.

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        for(ListNode head : lists){
            if(head != null){
                pq.add(head);
            }
        }
        
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            if(min.next != null){
                pq.add(min.next);
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
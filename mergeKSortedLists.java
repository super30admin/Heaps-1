// Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)

// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take a priority queue and add all heads of the lists given. Iterate till pq is empty and everytime take the node out and add
 * it to the dummy node and add the next node of min node to priority queue. Finally return dummy.next
 */
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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode head:lists){
            if(head!=null){
                pq.add(head);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next!=null){
                pq.add(min.next);
            }
        }
        return dummy.next;
    }
}

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

// https://leetcode.com/problems/merge-k-sorted-lists/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val-b.val);
        //put the heads
        for(ListNode head : lists){
            if(head != null) pq.add(head);
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr= dummy;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next= min;
            if(min.next!= null) pq.add(min.next);
            curr = curr.next;
        }
        return dummy.next;
    }
}
//Time complexity - O(nk log k)
//space complexity - O(k)

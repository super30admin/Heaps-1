// Time Complexity : O(nlogk) where k is the number of lists
// Space Complexity : O(k) at a time heap can have max k elements, where k is the number of lists
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach


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
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val - b.val);
        for(ListNode head : lists) {
            if(head != null)
                pq.add(head);
        }

        while(!pq.isEmpty()) {
            ListNode minNode = pq.poll();

            if(minNode.next != null) {
                pq.add(minNode.next);
            }
            dummy.next = minNode;
            dummy = dummy.next;
        }
        return result.next;
    }
}

// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
        if(lists == null || lists.length == 0){
            return null;
        }   

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        // insert all the head node in the queue
        for(ListNode list : lists){
            if(list != null){
                pq.add(list); 
            }
        }

        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null){
                pq.add(min.next);
            }
        }
        return dummy.next;
    }
}
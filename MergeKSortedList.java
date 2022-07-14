// Time Complexity : O(Nlogk)
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
        ListNode newHead = new ListNode(-1);
        if(lists == null || lists.length==0)
            return newHead.next;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(ListNode head : lists){
            if(head!=null)
                pq.add(head);
        }
        
        ListNode curr = newHead; 
        
        while(!pq.isEmpty()) {
            ListNode head = pq.poll();
            curr.next = head;
            curr = curr.next;
            if(head.next!=null) {
                pq.add(head.next);
            }
        }
        
        return newHead.next;
    }
}

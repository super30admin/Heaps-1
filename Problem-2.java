// Time Complexity : O(n)
// Space Complexity : O(n)
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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        for(ListNode node: lists) {
            if(node !=null) {
                pq.add(node);
            }
            
        }
        
        while(!pq.isEmpty()) {
            ListNode temp = pq.poll();
            if(temp.next != null) {
                pq.add(temp.next);
            }
            curr.next = temp;
            curr = curr.next;
        }
        
        return result.next;
    }
}
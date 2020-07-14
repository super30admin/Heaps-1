// Time Complexity :O(nklogk) n is the number of nodes in the lists array
// Space Complexity :O(k) k is the Priority Queue Size.
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
        ListNode dummy = new ListNode(-1);
        if(lists == null || lists.length ==0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val - b.val);
        ListNode result = dummy;
        for(ListNode node: lists){
            if(node!=null)pq.add(node);
        }
        
        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            dummy.next = curr;
            dummy = dummy.next;
            if(curr.next != null){
                curr = curr.next;
                pq.add(curr);
            }
            
        }
        
        return result.next;
    }
}
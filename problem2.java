// https://leetcode.com/problems/merge-k-sorted-lists/

// Time Complexity : O(nklogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(ListNode node: lists){
            if(node != null) pq.add(node);
        }
        
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        while(!pq.isEmpty()){
            ListNode newList = pq.poll();
            curr.next = newList;
            curr = curr.next;
            if(newList.next != null){
                pq.add(newList.next);
            }
        }
        return result.next;
    }
}
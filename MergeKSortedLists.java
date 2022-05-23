// Time Complexity :  O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode result = new ListNode();
        
        if(lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for(ListNode node: lists) {
            if(node != null)
                minHeap.add(node);
        }
        
        if(minHeap.isEmpty()) return null;
        ListNode dummy = result;
        while(!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            
            dummy.next = node;
            dummy = dummy.next;
            
            if(node.next != null) {
                minHeap.add(node.next);
            }
        }
        
        return result.next;
    }
}
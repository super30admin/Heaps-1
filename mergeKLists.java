// Time Complexity : O(nlogk)
// Space Complexity : O(k) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        Queue<ListNode>  minHeap = new PriorityQueue<ListNode>((a,b)->(a.val-b.val));
        
        for(ListNode node : lists) {
            if(node!=null)
                minHeap.add(node);
        }
        
        ListNode head = new ListNode(0);
        ListNode curr = head;
        
        while(!minHeap.isEmpty()) {
            
            ListNode temp = minHeap.poll();
            curr.next = temp;
            curr = curr.next;
            if(temp.next != null) {
                minHeap.add(temp.next);
            }
        }
        
        
        return head.next;
        
    }
}

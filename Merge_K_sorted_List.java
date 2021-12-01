// Time Complexity : O(NlogN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node:lists){
            ListNode curr=node;
            if(curr!=null){
                pq.add(curr);
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode head=dummy;
        
        while(!pq.isEmpty()){
            ListNode min=pq.poll();
            head.next=min;
            head=head.next;
            if(min.next!=null) pq.add(min.next);
        }
        
        return dummy.next;
      
    }
}
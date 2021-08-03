// Time Complexity : O(Nk(logk))
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

import java.util.PriorityQueue;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists == null || lists.length == 0)
            return null;
        
        //comparator doesn't know how to compare ListNodes so you need to specify
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val-b.val));
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;
        
        for(ListNode head: lists){
            if(head != null)
                pq.add(head);
        }
        
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            
            //since the min has been removed, we add the next node in this list
            if(min.next != null){
                pq.add(min.next);
            }
        }
        
        return dummy.next;
    }
    
}
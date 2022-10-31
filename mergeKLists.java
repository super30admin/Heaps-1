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
        
        if(lists==null) return null;
        
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        
        ListNode dummy=new ListNode();
        
        for(int i=0;i<lists.length;i++)
            if(lists[i]!=null)
                pq.add(lists[i]);
        
        ListNode tail=dummy;
        while(!pq.isEmpty())
        {
            ListNode min=pq.poll();
            if(min.next!=null)
                pq.add(min.next);
            tail.next=min;
            tail=tail.next;
        }
        
        return dummy.next;
        
        
        
    }
}

// Time Complexity : O(NKlogK)
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Time Complexity : O(nlogk) where n is the total number of elements, k is the length of lists and log k for insertion into pq
// Space Complexity : O(k) Pq size at every time where k is length of lists.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


import java.util.PriorityQueue;
/**
 * Definition for singly-linked list.
 * */
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for(int i=0; i<lists.length; i++)
            if(lists[i] != null)
                pq.offer(lists[i]);
        
        while(!pq.isEmpty())
        {
            ListNode node = pq.poll();
            if(node.next != null)
                pq.offer(node.next);
            current.next = node;
            current = node;
        }
        return dummy.next;
        
    }
} 

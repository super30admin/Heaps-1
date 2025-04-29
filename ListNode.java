// Time Complexity: O(N log k) 
// Space Complexity: O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

// Approach :
// Use a priority queue (min-heap) to store the current nodes of all lists.
// Extract the smallest node from the heap, add it to the result list, and insert its next node (if any) back into the heap.
// Continue this process until all nodes are merged into one sorted linked list.

import java.util.*;

class MergeKSortedLists 
{
    public class ListNode 
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) 
    {
        ListNode head = new ListNode();
        ListNode op = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode l1, ListNode l2) -> 
        {
            if(l1.val>l2.val)
            {
                return 1;
            }
            else
            {
                return -1;
            }
        });
        for(int i=0;i<lists.length;i++)
        {
            if(lists[i]!=null)
            {
                pq.add(lists[i]);
            }
        }
        while(!pq.isEmpty())
        {
            ListNode l = pq.poll();
            op.next = new ListNode(l.val);
            op = op.next;
            l = l.next;
            if(l!=null)
            {
                pq.add(l);
            }
        }
        return head.next;
    }
    
}
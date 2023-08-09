package org.example;
// Time Complexity : O(N(log k)) -> N is the total number of nodes in all the lists / k is the number of lists
// Space Complexity : O(k) ->space of queue
// Did this code successfully run on Leetcode : Yes
import java.util.PriorityQueue;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class MergeKSortedListsUsingHeap {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val - b.val);
        ListNode result = new ListNode(-1);
        for(ListNode node: lists)
        {
            if(node!=null)
            {
                pq.add(node);
            }
        }

        ListNode tempResult = result;
        while(!pq.isEmpty())
        {
            ListNode min = pq.poll();
            tempResult.next = min;
            tempResult = tempResult.next;

            if(min.next != null)
            {
                pq.add(min.next);
            }
        }
        return result.next;
    }
}

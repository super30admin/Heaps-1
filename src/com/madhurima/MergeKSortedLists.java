// Time Complexity : nkO(logk) where k is size of  min-heap
// Space Complexity : O(k) i.e. size of min-heap
// Did this code successfully run on Leetcode : yes


package com.madhurima;

import java.util.PriorityQueue;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        //min heap to get min out of k heads, where k is number of lists
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode list: lists){
            if(list != null){
                pq.add(list);
            }
        }

        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            if(min != null){
                curr.next = min;
                if(min.next != null){
                    pq.add(min.next);
                }
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}

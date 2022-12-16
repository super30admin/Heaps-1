// n is avg list size, k is number of lists

// using priority queue
// Time Complexity : O(nklogk) where k is size of min-heap
// Space Complexity : O(k) i.e. size of min-heap

// using two pointers
// Time Complexity : O(nk*k) merging list of size nk k times
// Space Complexity : O(nk) i.e. size of merged list

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

    //using priority queue
    public ListNode mergeKListsPriorityQueue(ListNode[] lists) {
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


    //using two pointers
    public ListNode mergeKListsTwoPointers(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        ListNode merged = new ListNode(Integer.MIN_VALUE);
        for(ListNode list: lists){
            merged = merge(merged, list);
        }

        return merged.next;

    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if(l1 != null){
            curr.next = l1;
        }

        if(l2 != null){
            curr.next = l2;
        }

        return dummy.next;
    }
}

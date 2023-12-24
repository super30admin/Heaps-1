// Time Complexity : O(N logk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes

import java.util.PriorityQueue;

public class MergeLinkedList {
    public ListNode mergeKLists(ListNode[] lists) {
      PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>((a, b)->a.val-b.val);
      ListNode head=null;
      for(ListNode i : lists){
        if(i != null)heap.add(i);
      }

      head= heap.poll();
      ListNode p = head;

      while(!heap.isEmpty()){
        if(p.next != null)heap.add(p.next);

        p.next=heap.poll();
        p=p.next;
      }
      return head;
    }
  }


// Time Complexity : O(nk log k); heap of size k so log k
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes

import java.util.PriorityQueue;

public class MergeKLists {

      public class ListNode {
          int val;
          ListNode next;

          ListNode() {
          }

          ListNode(int val) {
              this.val = val;
          }

          ListNode(int val, ListNode next) {
              this.val = val;
              this.next = next;
          }
      }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>( (a, b) -> a.val - b.val);

        //add heads of all lists onto heap
        for(ListNode head : lists){
            if(head!= null){
                pq.add(head);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode min = pq.poll(); //log k
            curr.next = min;
            if(min.next != null){
                pq.add(min.next);
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}


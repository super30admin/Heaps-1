import java.util.PriorityQueue;

public class MergeKSortedList {
/*
// Time Complexity : O(NlogN)
// Space Complexity : O(N)

 */

     //* Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution {

        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> q =new PriorityQueue<>((a, b) -> a.val-b.val);
            for(ListNode l : lists) {
                if(l !=null)
                    q.add(l);
            }
            ListNode dummy = new ListNode();
            ListNode curr = dummy ;
            while(!q.isEmpty()) {
                ListNode min = q.poll();
                curr.next =min;
                if(min.next !=null)
                    q.add(min.next);
                curr =curr.next;
            }
            return dummy.next;
        }
    }
}

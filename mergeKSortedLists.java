//Time Complexity: O(m * n) //Where m is length of lists and n is length of each linked list
//Space Complexity: O(m * n) 

import java.util.*; 
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(ListNode list: lists) {
          ListNode head = list;
          while(head != null) {
              q.add(head.val);
              head = head.next;
              //ListNode next = cp.next;
              //cp.next = null;
              //cp = next;
          }
        }

        ListNode head = new ListNode();
        ListNode target = head;

        while(!q.isEmpty()) {
             target.next = new ListNode(q.poll());
             target = target.next;
        }

        return head.next;
    }
}
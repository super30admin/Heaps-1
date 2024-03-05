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
 //TimeComplexity : O(Nlog(k))
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
          PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
          ListNode dummy = new ListNode(-1);
          for(ListNode head: lists) {
              if(head!= null) {
              pq.add(head);
              }
          }
          ListNode current = dummy;
          while(!pq.isEmpty()) {
              ListNode minimum = pq.poll();
              current.next = minimum;
              current = current.next;
              if(minimum.next != null) {
                pq.add(minimum.next);
              }

          }
          return dummy.next;
    }
}
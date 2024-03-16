//TC: O(Nlog(k))
//SC: O(1)
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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result=new ListNode(-1);
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode curr=result;
        for(ListNode head: lists)
        {
           if(head!=null)
           pq.add(head);
        }

        while(!pq.isEmpty())
        {
          ListNode min=pq.poll();
          curr.next=min;
          curr=min;
          if(min.next!=null)
          pq.add(min.next);  
        }
        return result.next;
            }
}
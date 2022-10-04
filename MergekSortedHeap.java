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
    //tc-nklogk
    //sc-o(k)
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->(a.val-b.val));
        ListNode result;
        for(ListNode head : lists)
        {
            if(head!=null)
            {
                pq.add(head);
            }
        }
        result = new ListNode(-1);
        ListNode curr = result;
        while(!pq.isEmpty())
        {
           ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null)
            {
               pq.add(min.next);
            }
        }
        return result.next;
        
    }
}
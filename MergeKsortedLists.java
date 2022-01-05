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
//
//T.C = nk(logk)
//S.C = O(k)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        for(ListNode list : lists)
        {
            if(list!=null)
            pq.add(list);
        }
        
        while(!pq.isEmpty())
        {
            ListNode min = pq.poll();
            curr.next = min;
            if(min.next!=null)
            pq.add(min.next);
            curr=curr.next;
        }
        
        return dummy.next;
        
        
    }
}
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
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode head : lists){
            if(head!=null) pq.add(head);
        }
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            dummy.next = min;
            dummy = dummy.next;
            min = min.next;
            if(min!=null) pq.add(min);
        }
        return res.next;
    }
}

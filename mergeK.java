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

//  tc: klog k
// sc: k
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode a,ListNode b)->a.val-b.val);

        for(ListNode head:lists){
            if(head!=null)
            pq.add(head);
        }

        ListNode dummy = new ListNode (-1);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode minNode = pq.poll();
            curr.next=minNode;
            curr=curr.next;
            if(minNode.next!=null){
                pq.add(minNode.next);
            }
        }
        curr.next=null;
        return dummy.next;
    }
}
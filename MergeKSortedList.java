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
 /*Time Complexity : O(klogN)
 Space COmplexity : O(K)
 Idea store poiters to head of list and put all of them in pq and then pop min and advance the poiter of that head
 reinsert it into heap if it is not null.
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->(a.val - b.val));
        for(ListNode head : lists){
            if(head!=null)
             pq.add(head);
        }
        ListNode temp = dummy;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            temp.next = node;
            node = node.next;
            if(node!=null){
                pq.add(node);
            }
            temp = temp.next;
        }
        return dummy.next;
    }
}
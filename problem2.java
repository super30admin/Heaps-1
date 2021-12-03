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
     
        PriorityQueue <ListNode> pq = new PriorityQueue <> ((a,b) ->a.val-b.val);
        ListNode first = new ListNode();
        ListNode last = first;
        for(ListNode head:lists){
            if(head!=null){
                pq.add(head);
            }
        }
        while(!pq.isEmpty()){
            ListNode out = pq.poll();
            last.next = out;
            last = out;
            if(out.next !=null){
                pq.add(out.next);
            }
        }
        return first.next;
        
    }
}
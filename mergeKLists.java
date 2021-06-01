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
        ListNode curr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode head : lists){
            if(head != null){
                pq.add(head);
            }
        }
        
        while(!pq.isEmpty()){
            ListNode minimum = pq.poll();
            curr.next = minimum;
            curr = curr.next;
            
            if(minimum.next != null){
                pq.add(minimum.next);  
            }
        }
        return dummy.next;
    }
}

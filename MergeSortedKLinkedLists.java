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
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(ListNode l : lists){
            while(l != null){
                pq.add(l.val);
                l = l.next;
            }
        }
        
        ListNode dummy_head = new ListNode(-1);
        ListNode head = dummy_head;
        
        while(!pq.isEmpty()){
            head.next = new ListNode(pq.remove());
            head = head.next;
        }
        
        return dummy_head.next;
    }
}
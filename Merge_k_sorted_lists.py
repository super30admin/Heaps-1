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
        // Create a Min heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        // result stored in Dummy
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;
        
        // Add all the first nodes in each list into the min heap
        for(ListNode head: lists){
            if(head != null){
                pq.add(head);
            }
        }
        
        // The root in the heap will give the min value and add into the result list: curr
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            
            // add the next node in the list which we removed the node.
            if(min.next != null) {
                pq.add(min.next);
            }
        }
        
        return dummy.next;
    }
}
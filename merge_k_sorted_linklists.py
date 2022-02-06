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
# tc : O(nk logk)
# SC: O(k)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val );
        
        for (ListNode head : lists){
            if( head!=null){
                pq.add(head);
            }
        }
        
        ListNode res;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy ;
        
        while(!pq.isEmpty()){
            ListNode min = pq.poll(); // returns min node and also pops it
            curr.next = min;
            if (min.next!=null)
                pq.add(min.next);
            curr = curr.next;
            
        }
        return dummy.next;
    }
}

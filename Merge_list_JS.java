//Running time Complexity: O(nklog(k))
//Space Time Complexity: log k
//Successfully Compiled and Run on leetcode
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
        if(lists == null ) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val - b.val);
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        for (ListNode head : lists){
            if(head!=null){
                pq.add(head);
            }
        }
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next!=null){
                pq.add(min.next);
                
            }
            
        }
        return result.next;
    }
}
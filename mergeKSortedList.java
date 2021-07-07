// Time Complexity: O(nklogk) where n is the number of elements in lists and k is the number of given lists
//Space Complexity: O(k) since we are maitaining PQ to hold one element from each given lists at any given time

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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for(ListNode head: lists){
            if(head != null)    pq.add(head);
        }
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = min;
            if(min.next != null) pq.add(min.next);
        }
        
        return dummy.next;
    }
}
/**LC-23
 * 
 * Time Complexity : O(nklogk)  k: no. of lists  n: average length of the list
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : Yes. At line 33...got confused
 * 
 * Algorithm:
 * 1. First we store all the heads in the PQ. We will use Min heap
 * 2. Now since it is a min heap, we pop the root which has the smallest value and add it the resultant list
 * 3. Increase the pointer of the node which we just addded to the resultant
 */
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
        
        if(lists == null || lists.length == 0) return null;
        int n = lists.length;
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode head: lists){
        
            if(head != null)
                pq.add(head);            
        }
        
        while(!pq.isEmpty()){
            
            ListNode min = pq.poll();
            dummy.next = min;
            dummy = dummy.next;
            if(min.next != null)
                pq.add(min.next);
        }
        return result.next;
    }
}
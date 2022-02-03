// Time Complexity : O(nklog(k)); where k is number of sorted lists
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        // insert all the heads inside the heap
        for(ListNode head : lists){
            if(head != null){
                pq.add(head);            
            }
        }
        
        // maintain a dummy node to return the combined sorted list
        ListNode dummy = new ListNode(-1);
        // maintain a pointer to traverse and insert the elements to the list
        ListNode curr = dummy;
        
        while(!pq.isEmpty()){
            // remove the top element(smallest) from the min heap 
            ListNode min = pq.poll();
            // attach it to the curr's next
            curr.next = min;
            // if next element exists then add it to the heap
            if(min.next != null){
                pq.add(min.next);
            }
            
            // go to the next node
            curr = curr.next;
        }
        
        return dummy.next;      
        
    }
}
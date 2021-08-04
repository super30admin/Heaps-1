// Time Complexity : O(N log K)
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach

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
        
        if(lists == null || lists.length == 0)
            return null;
        
        PriorityQueue<ListNode> pqueue = new PriorityQueue<>((a,b) -> (a.val - b.val));
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE), curr = dummy;
        
        for(ListNode head: lists){
            //add all the head to each head to pqueue
            if(head != null)
                pqueue.add(head);
        }
        
        while(!pqueue.isEmpty()){
            ListNode min = pqueue.poll();
            //add min node to dummy list
            curr.next = min;
            //update curr pointer
            curr = curr.next;
            
            //check for next element in the min node list and add to the queue
            //do this till all the elements in all the lists
            if(min.next != null){
                pqueue.add(min.next);
            }
        }
        
        return dummy.next;
        
    }
}
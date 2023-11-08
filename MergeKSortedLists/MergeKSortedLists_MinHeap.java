/* Time Complexity : O(nklog (k))
 *	n - avg len of the lists - nums
 * 	k - number of lists */
/* Space Complexity : O(k)
 *  size of the priority queue - k */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :
 
 //MinHeap

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
		//Add first nodes of all the lists to the queue
        for(ListNode head: lists){
            if(head != null){
                pq.add(head);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
		//Get the top node and increment the pointer on that list and add the polled value to the result
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null){
                pq.add(min.next);
            }
        }
        return dummy.next;
    }
}
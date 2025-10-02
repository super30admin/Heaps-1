// Time Complexity : O(nlogk) where n is total number of nodes and k is number of lists
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We use a MIN heap and add the heads of the list nodes into the heap
// We then loop through the queue and pop the minimum node and append it to merged list
// We subsequently then add the next nodes of the min nodes into the queue

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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val - b.val));
        //add the heads of list nodes to pq which is of size k
        for(ListNode list: lists) {
            if(list != null) {
                pq.add(list);
            } 
        }
        //create a dummy node
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(!pq.isEmpty()) {
            ListNode min = pq.poll();
            //append it to merged list
            cur.next = min;
            cur = cur.next;
            //add the next min to pq
            if(min.next != null) {
                pq.add(min.next);
            }
        }
        return dummy.next;
        
    }
}

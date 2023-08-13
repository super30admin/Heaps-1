// Time Complexity :O(nlog(k))
// Space Complexity :O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
        //Min Priority queue to keep track of smallest integer and the size will be k
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (
            a.val-b.val
        ));
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        //Put all the heads in the pq
        for(int i=0; i<lists.length; i++){
                
                if(lists[i] != null){
                    pq.add(lists[i]);
                }
            }

        //Remove the smallest elements and add it to the result linked list
        //Put the next node of the smallest node in pq
        while(pq.peek() != null){
            ListNode node = pq.poll();
            head.next = node;
            head = head.next;
            if(node.next!=null) pq.add(node.next);
        }

        return dummy.next;

    }
}
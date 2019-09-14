/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
*/


// T: O (n * log K) // where k = number of lists, n = total number of elements

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode dummy = new ListNode(0);
        
        ListNode result = dummy;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(
        (ListNode a, ListNode b) -> (a.val - b.val));
        
        for(ListNode headNode: lists){
            
            if(headNode != null) pq.add(headNode);
        }
        
        while(!pq.isEmpty()){
            
            ListNode min = pq.poll();
            dummy.next = min;
            dummy = dummy.next;
            
            if(min.next != null){
                pq.add(min.next);
            }
        }
        
        return result.next;
    }
}
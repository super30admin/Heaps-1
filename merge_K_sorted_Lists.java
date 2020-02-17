/*
Time Complexity : mergeKLists_priorityQ() - O(n*logk) - n is the maximum length of a list
				  mergeKLists_bruteForce() - O(kn) - where k is number of lists and n is the 
				                                     average number of elements in a list
Space Complexity : mergeKLists_priorityQ() - O(k) - 
				   mergeKLists_bruteForce() - O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public ListNode mergeKLists_priorityQ(ListNode[] lists){
		if (lists == null || lists.length == 0)
            return null;
        
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.add(node.next);
            }
            
            dummy.next = node;
            dummy = dummy.next;
        }
        
        return result.next;
	}
	
	
    public ListNode mergeKLists_bruteForce(ListNode[] lists) {
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        ListNode result = merged;
        
        for (int i = 0; i < lists.length; i++) {
            merged = merge(merged, lists[i]);
        }
        
        return result.next;
    }
    
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode result = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            }
            else {
                dummy.next = l2;
                l2 = l2.next;
            }
            
            dummy = dummy.next;
        }
        
        if (l1 != null) {
            dummy.next = l1;
        }
        
        if (l2 != null) {
            dummy.next = l2;
        }
        
        return result.next;
    }
}
//Time Complexity : O(NlogK) N = total words, K = highest list length
//Space Complexity : O(NK)  
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

import java.util.PriorityQueue;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
/**
 * Put all non-null lists to Priority queue. While popping each node, add it to
 * the a new list and then push the node's next element to the queue.
 *
 */
class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
		for (ListNode list : lists) {
			if (list != null)
				pq.offer(list);
		}
		ListNode dummy = new ListNode(0);
		ListNode ptr = dummy;
		while (!pq.isEmpty()) {
			ListNode node = pq.poll();
			ptr.next = node;
			ptr = node;
			if (node.next != null)
				pq.add(node.next);
		}
		return dummy.next;
	}
}
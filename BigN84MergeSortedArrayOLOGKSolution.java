//Time complexity is O(nlogk)
//Space complexity is O(k)
//This solution is submitted on leetcode

import java.util.PriorityQueue;

public class BigN84MergeSortedArrayOLOGKSolution {
	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode
	 * next; ListNode(int x) { val = x; } }
	 */

	public class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	class Solution {
		public ListNode mergeKLists(ListNode[] lists) {
			// edge case
			if (lists == null || lists.length == 0)
				return null;
			ListNode dummy = new ListNode(-1);
			ListNode result = dummy;
			PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
			for (ListNode head : lists) {
				if (head != null)
					pq.add(head);
			}
			
			while (!pq.isEmpty()) {
				ListNode min = pq.poll();
				dummy.next = min;
				dummy = min;
				if (min.next != null) {
					// add min.next not min
					pq.add(min.next);
				}
			}
			return result.next;
		}
	}
}
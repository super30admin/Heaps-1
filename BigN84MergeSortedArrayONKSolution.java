// Time complexity is O(nk)
// Space complexity is O(nk)
// This solution is submitted on leetcode

public class BigN84MergeSortedArrayONKSolution {
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

	public ListNode mergeKLists(ListNode[] lists) {
		// edge case
		if (lists == null || lists.length == 0)
			return null;
		// Dont make two nodes dummy of -1 value
		ListNode merged = new ListNode(Integer.MIN_VALUE);
		ListNode result = merged;
		for (ListNode list : lists) {
			merged = merging(merged, list);
		}
		return result.next;
	}

	private ListNode merging(ListNode node1, ListNode node2) {
		ListNode dummy = new ListNode(-1);
		ListNode compare1 = node1;
		ListNode compare2 = node2;
		ListNode merged = dummy;
		while (compare1 != null && compare2 != null) {
			if (compare1.val < compare2.val) {
				dummy.next = compare1;
				dummy = compare1;
				compare1 = compare1.next;
			} else {
				dummy.next = compare2;
				dummy = compare2;
				compare2 = compare2.next;
			}
		}
		if (compare1 != null) {
			dummy.next = compare1;
		}
		if (compare2 != null) {
			dummy.next = compare2;
		}
		return merged.next;
	}
}
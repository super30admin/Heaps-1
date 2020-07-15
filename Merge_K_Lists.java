
//Time Complexity : O(NKlogK))
//Space Complexity: O(K)
import java.util.*;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

class Solution2 {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		ListNode dummy = new ListNode(-1);
		ListNode result = dummy;
		PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
		for (ListNode head : lists) {
			if (head != null) {
				pq.add(head);
			}
		}
		while (!pq.isEmpty()) {
			ListNode min = pq.poll();
			dummy.next = min;
			dummy = dummy.next;
			if (min.next != null) {
				min = min.next;
				pq.add(min);
			}
		}
		return result.next;
	}
}
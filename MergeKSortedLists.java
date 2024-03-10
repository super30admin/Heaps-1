package week7.day1;

import java.util.PriorityQueue;

// TC - O(N log N)
// SC - O(log N)
/**
 * 1. insert only the first nodes in the PQ (node!=null) 2. PQ automatically
 * moves the min to top 3. Remove top from PQ. Add it to dummy.next 4. Add the
 * removed node's next to PQ (node!=null) 5. return dummy's head.next
 */
class Solution5 {
	public ListNode mergeKLists(ListNode[] lists) {

		PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
		ListNode dummy1 = new ListNode(-1);

		for (ListNode head : lists) {
			if (head != null)
				pq.add(head);
		}
		ListNode dummy = dummy1;
		while (!pq.isEmpty()) {
			ListNode min = pq.poll();
			dummy.next = min;
			dummy = dummy.next;
			min = min.next;
			if (min != null)
				pq.add(min);
		}
		return dummy1.next;

	}
}
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

public class MergeKSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

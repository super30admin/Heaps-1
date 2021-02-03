import java.util.PriorityQueue;

/*
 * Time Complexity of the algorithm is O(nk log K) where n is no of elements in a array and k is size of heap
 * space Complexity will O( k) where k is size of heap
 */

public class MergekSortedLists {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {

		PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

		ListNode dummy = new ListNode(-1);
		ListNode result = dummy;

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
				pq.add(min.next);
			}

		}

		return result.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

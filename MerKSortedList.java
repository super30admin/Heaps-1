// Time Complexity : O (NlogK)
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach



import java.util.*;


public class MerKSortedList {

	ListNode headA;
	ListNode headB;
	ListNode headC;

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {

		Comparator<ListNode> comp = new Comparator<ListNode>() {

			@Override
			public int compare(ListNode a, ListNode b) {

				return a.val - b.val;
			}

		};

		PriorityQueue<ListNode> minHeap = new PriorityQueue<>(comp);
		for (ListNode head : lists) {
			if (head != null)
				minHeap.add(head);
		}

		ListNode result = new ListNode(0);
		ListNode cursor = result;

		while (!minHeap.isEmpty()) {

			ListNode minElement = minHeap.poll();
			cursor.next = minElement;
			cursor = minElement;
			if (minElement.next != null) {
				minHeap.add(minElement.next);
			}

		}

		return result.next;
	}

	
	private void printLinkedList(ListNode head) {

		ListNode l = head;

		while (l != null) {
			System.out.println(l.val);
			l = l.next;
		}
	}
	public static void main(String[] args) {
		MerKSortedList m = new MerKSortedList();
		m.headA = m.new ListNode(1);
		m.headA.next = m.new ListNode(4);
		m.headA.next.next = m.new ListNode(5);

		m.headB = m.new ListNode(1);
		m.headB.next = m.new ListNode(3);
		m.headB.next.next = m.new ListNode(4);

		m.headC = m.new ListNode(2);
		m.headC.next = m.new ListNode(6);

		ListNode res = m.mergeKLists(new ListNode[] { m.headA, m.headB, m.headC });
		m.printLinkedList(res);
		
	}

}

package problem2;

//Time Complexity : O(n logk), n -> Total Number of elements, k -> Given number of lists
//Space Complexity : O(k)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
import java.util.PriorityQueue;

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		ListNode dummyHead = new ListNode();
		ListNode curr = dummyHead;

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((n1, n2) -> n1.val - n2.val);

		for (ListNode node : lists) {
			if (node != null) {
				queue.add(node);
			}
		}

		while (!queue.isEmpty()) {
			ListNode node = queue.poll();
			curr.next = node;
			curr = curr.next;

			if (node.next != null) {
				queue.add(node.next);
			}
		}

		return dummyHead.next;
	}

	public void print(ListNode head) {
		ListNode curr = head;

		while (curr.next != null) {
			System.out.print(curr.val + " --> ");
			curr = curr.next;
		}
		System.out.print(curr.val);
		System.out.println();
	}

	public static void main(String[] args) {
		MergeKSortedLists obj = new MergeKSortedLists();
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(4);
		head1.next.next.next = new ListNode(8);

		ListNode head2 = new ListNode(3);
		head2.next = new ListNode(6);
		head2.next.next = new ListNode(9);

		ListNode head3 = new ListNode(2);
		head3.next = new ListNode(4);

		ListNode[] lists = { head1, head2, head3 };

		System.out.println("Given Lists:");
		for (ListNode list : lists) {
			obj.print(list);
		}

		ListNode ans = obj.mergeKLists(lists);
		System.out.println("Merged List: ");
		obj.print(ans);
	}

}

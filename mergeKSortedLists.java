// TC: O(N) since we are traversing through the lists twice.
// SC: O(N) since we are using priorityqueeue for storing list node values

// Store the values in priorityQueue since it will store all the as minHeap and it ll store in sorted order, we can retrive it easily.
// Now, create a new ListNode where we can just remove the elements from minHeap and add it to the listnode

import java.util.PriorityQueue;

public class mergeKSortedLists {

	public ListNode mergekLists(ListNode[] lists) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(ListNode node: lists) {
			pq.add(node.data);
			node = node.next;
		}
		
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		
		while(!pq.isEmpty()) {
			head.next = new ListNode(pq.remove());
			head = head.next;
		}
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		
		mergeKSortedLists mk = new mergeKSortedLists();
		
	}
}

// Time Complexity : O(NK log K) // K is the number of lists,N is the length of the each list. logK for heapify function
// Space Complexity :O(K) //at max minheap will contain K elements. One node per list
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

/*
 * 1. implemented using min heap see inline comments
 */

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		//Priority queue
		Queue<ListNode> q = new PriorityQueue<ListNode>((a,b)->a.val-b.val);
		
		//add all the list nodes first node to the min heap
		for (ListNode l : lists) {
			if (l != null) {
				q.add(l);
			}
		}
		
		//head pointer dummy node to return at the end 
		ListNode head = new ListNode(-1);
		//for current pointer
		ListNode cur = head;
		
		//every time get top element from minheap and add it to result list
		//also add next node of the poll node to the minheap
		while (!q.isEmpty()) {
			cur.next = q.poll();
			cur = cur.next;
			ListNode next = cur.next;
			if (next != null) {
				q.add(next);
			}
		}
		
		//return next of dummy node
		return head.next;
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

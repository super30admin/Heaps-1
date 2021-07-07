package com.exmaple.problems;

import java.util.PriorityQueue;
import java.util.Comparator;

//Time Complexity : O(log N) for Heap
//Space Complexity : O(K) for Heap 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach
/*
* There are two approaches to find kth Largest element
* Quick Select  quickselect is a selection algorithm to find the kth smallest element in an unordered list.
* Heap We can use min heap or max heap to merge kth sorted list.We keeping adding list to priority queue
* Finally we have heap of node in sorted order.Remove node from queue and attach it to dummy node
* and return the node
* */
public class MergeSortedLinkedList {
	public ListNode mergeKLists(ListNode[] lists) {

		PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
			public int compare(ListNode a, ListNode b) {
				return a.val - b.val;
			}
		});
		if (lists.length == 0)
			return null;
		for (ListNode list : lists) {
			if (list != null) {
				queue.add(list);
			}
		}
		ListNode head = null, last = null;
		while (!queue.isEmpty()) {
			ListNode top = queue.poll();
			if (top.next != null) {
				queue.add(top.next);
			}
			if (head == null) {
				head = last = top;
			} else {
				last.next = top;
				last = top;
			}
		}
		return head;
	}
}

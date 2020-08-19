import java.util.PriorityQueue;
//Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
/****************************************Using Priority Queue(Min heap)*********************************/
//Time Complexity : O(nklog k), where nk is total number of elements in result and log k is time to heapify k list nodes
//Space Complexity : O(k), heap size
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : No

/**By maintaining the current ListNode type pointers in the priority Queue(min heap)
 * Add the top node(minimum) in the priority queue to the resultant ListNode
 * Move the pointer to the next element of the current listNode at top of the queue. Continue until the q is empty**/

public class Merge_k_Sorted_Lists {
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0)
			return null;

		PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);    //custom comparator, to access value of listnodes
		ListNode dummy = new ListNode(-1);
		ListNode result = dummy;
		for(ListNode firstNode_OfLists: lists){
			if(firstNode_OfLists != null)
				pq.add(firstNode_OfLists);  // add the first node of lists
		}

		while(!pq.isEmpty()){
			ListNode min = pq.poll();   // get the min value from top of the heap
			dummy.next = min;
			dummy = dummy.next;

			if(min.next != null)
				pq.add(min.next);   // add corresponding min value to queue
		}
		return result.next;
	}
}

/********************Using Merge Method: Merge 2 sorted lists and then with other lists*************************/
//Time Complexity : O(n K^2), as we merge k lists having elements nk
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : No

class Merge_2_Sorted_Lists_then_K {
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0)
			return null;
		ListNode mergedList = null;
		for(ListNode list: lists)
			mergedList = mergeTwoLists(mergedList, list);

		return mergedList;
	}
	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;

		ListNode dummy = new ListNode(-1);
		ListNode result = dummy;
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){    //if l1 is small
				dummy.next = l1;    // point dummy to l1
				l1 = l1.next;   //move l1
			}
			else {  //if l2 is small
				dummy.next = l2;    // point dummy to l2
				l2 = l2.next;   //move l2
			}
			dummy = dummy.next; //move dummy each time
		}
		if(l1 != null)
			dummy.next = l1;

		if(l2 != null)
			dummy.next = l2;

		return result.next;
	}  
}
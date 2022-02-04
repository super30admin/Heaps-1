package heaps1;

import java.util.PriorityQueue;

public class MergeKSortedLists {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	//Time Complexity : O(nk log k), where n is the max elements in a list and 
	//k is the number of lists 
	//Space Complexity : O(k), where k is the size of minHeap
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for(ListNode node: lists) {
            if(node != null)
                minHeap.offer(node);
        }
        
        ListNode res = new ListNode();
        ListNode dummy = res;
        while(!minHeap.isEmpty()) {
            ListNode curr = minHeap.poll();
            res.next = curr;
            if(curr.next != null)
                minHeap.offer(curr.next);
            res = res.next;
        }
        
        return dummy.next;
    }
	 
	//Time Complexity : O(n k^2), where n is the elements in the list and k is total 
	//number of lists
	//Space Complexity : O(n), for new linked list
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public ListNode mergeKLists1(ListNode[] lists) {
        ListNode res = new ListNode(Integer.MIN_VALUE);
        
        for(ListNode node: lists)
            res = merge(res, node);
        
        return res.next;
    }
    
    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        
        while(h1 != null && h2 != null) { 
            if(h1.val < h2.val) {
                curr.next = h1;
                h1 = h1.next;
            } else {
                curr.next = h2;
                h2 = h2.next;
            }
            curr = curr.next;
        }
        
        if(h1 != null)
            curr.next = h1;
            
        if(h2 != null)
            curr.next = h2;
        
        return dummy.next;
    }
}

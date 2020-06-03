package s30Coding;
import java.util.*;

//Time Complexity :- O(nklog(k))
//Space Complexity :- O(k)

public class MergeKSortedLists {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	 public ListNode mergeKLists(ListNode[] lists) {
	      if(lists == null || lists.length == 0){
	          return null;
	      }  
	        ListNode dummy = new ListNode(-1);
	        ListNode result = dummy;
	        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
	        for(ListNode head : lists){
	            if(head !=null) pq.add(head);
	        }
	        while(!pq.isEmpty()){
	            ListNode min = pq.poll();
	            dummy.next = min;
	            dummy = dummy.next;
	            if(min.next !=null){
	                pq.add(min.next);
	            }
	        }
	        return result.next;
	    }
}

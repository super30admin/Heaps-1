import java.util.PriorityQueue;

public class MergeKListsUsingHeap {
	 public ListNode mergeKListsUsingHeap(ListNode[] lists) {
		    
	       ListNode dummy = new ListNode(-1);    
	       PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a,b)->a.val - b.val);
	       for(ListNode head:lists){
	           
	           if(head!=null){
	                pq.add(head);
	           }
	       }
	        ListNode result = dummy;
	        
	        while(!pq.isEmpty()){
	            
	            ListNode min = pq.poll();
	            dummy.next = min;
	            dummy = dummy.next;
	            
	            if(min.next!=null)
	                pq.add(min.next);
	        }
	        
	        return result.next;
	    }
}

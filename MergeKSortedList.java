import java.util.PriorityQueue;
//Time Complexity : O(NKLogK)
//Space Complexity :O(K) 
//Did this code successfully run on Leet code :Yes
//Any problem you faced while coding this :


public class MergeKSortedList {
	 public ListNode mergeKLists(ListNode[] lists) {
	        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) ->(a.val-b.val) );
	      
	        ListNode result = new ListNode(Integer.MIN_VALUE);
	        ListNode curr = result;
	       
	        for(ListNode listnode:lists){
	           if(listnode!=null)
	            pq.add(listnode);
	        }
	        
	        while(!pq.isEmpty()){
	           ListNode temp = pq.poll();
	            if(temp.next!=null)
	                pq.add(temp.next);
	            curr.next = temp;
	            curr = temp;
	        }
	        return result.next;
	    }
}

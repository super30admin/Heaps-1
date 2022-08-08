//Time Complexity: O(n*k*log(k))
//Space complexity: O(k)
//Code run successfully on LeetCode.

public class Problem2_1 {

    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists == null|| lists.length == 0)
            return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        for(ListNode head : lists){
            
            if(head != null)
                pq.add(head);
        }
        
        while(!pq.isEmpty()){
            
            ListNode min = pq.poll();
            
            curr.next = min;
            
            if(min.next != null)
                pq.add(min.next);
            
            curr = curr.next;
        }
        
        return dummy.next;
    }
	
}

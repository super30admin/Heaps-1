//23. Merge k Sorted Lists
//Time Complexity: O(nlog(k)) , total no of nodes and k is the no of linked lsit heads
//Space Complexity: O(log(k)) , k is the no of linked lsit heads
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        
        PriorityQueue<ListNode> pq= new PriorityQueue<>((a,b) -> (a.val-b.val));
        
        for(ListNode n: lists){
            if(n!=null) pq.offer(n);
            
        }
        ListNode dummy= new ListNode(-1);
        ListNode refHead= dummy;
        
        while(!pq.isEmpty()){
            ListNode m= pq.poll();
            refHead.next= m;
            if(m.next!=null){
                pq.offer(m.next);
            }
            refHead= refHead.next;
        }
        
        return dummy.next;
    }
}
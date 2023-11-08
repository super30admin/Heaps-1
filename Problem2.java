// Time Complexity : O(Nlogk)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
       PriorityQueue<ListNode> pq = new PriorityQueue<>((p,q) -> p.val - q.val);   
       ListNode dummy = new ListNode(-1);
       ListNode curr = dummy;
       for(ListNode node : lists){
           if(node!=null)
            pq.add(node);
       }
        while(pq.size() > 0){
            ListNode popped = pq.poll();
            curr.next = popped;
            curr = curr.next;
            if(popped.next!=null)
                pq.add(popped.next);
            }
        return dummy.next;

    }
}
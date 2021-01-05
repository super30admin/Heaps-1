// Time Complexity : O(total no.of nodes * logk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
      PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> {
    return o1.val - o2.val;
  });
        
        for(ListNode head : lists) {
            if(head != null)
                pq.add(head);
        }
        
        ListNode dummy = new ListNode();
        ListNode result = dummy;
        while(!pq.isEmpty()) {
            result.next = pq.poll();
            result = result.next;
            if(result.next != null)
                pq.add(result.next);
        }
        
        return dummy.next;
        
    }
}
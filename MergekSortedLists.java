// Time Complexity : O(nklogk), k = number of lists, n = number of elements in longest list 
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        
        PriorityQueue<ListNode> pqueue  = new PriorityQueue<>((a,b) -> (a.val-b.val));
        ListNode dummy = new ListNode(Integer.MIN_VALUE), curr = dummy;
        
        for(ListNode head : lists) {
            if(head != null)
                pqueue.add(head);
        }
        
        while(!pqueue.isEmpty()) {
            ListNode min = pqueue.poll();
            curr.next = min;
            curr = curr.next;
            
            if(min.next != null)
                pqueue.add(min.next);
        }
        return dummy.next;
    }
}
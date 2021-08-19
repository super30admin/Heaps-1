//Time Complexity : O(n logk), n -> Total Number of elements, k -> Given number of lists
//Space Complexity : O(k)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> pqueue = new PriorityQueue<>((a,b) -> (a.val - b.val));
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;
        
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
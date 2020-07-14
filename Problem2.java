//time o(nklog(k))
//space o(k)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        ListNode result = new ListNode(0);
        ListNode cur = result;
        
        for(ListNode head : lists) {
            if(head != null)
            {
                pq.add(head);
            }
        }
        
        while(!pq.isEmpty()) {
            cur.next = pq.peek();
            ListNode temp = pq.poll();
            if(temp.next != null)
            {
                pq.add(temp.next);
            }
            cur = cur.next;
        }
        return result.next;
    }
}
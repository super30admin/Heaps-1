class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode x : lists){
            if(x != null)
            pq.add(x);
        }

        ListNode d = new ListNode();
        ListNode c = d;
        while(!pq.isEmpty()){
            ListNode m = pq.remove();
            c.next = m;
            c = c.next;
            if(m.next != null) {
                pq.add(m.next);
            }
        }
        return d.next;
    }
}
//tc= k+logk
//sc= k+logk

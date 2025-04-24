package week7.heaps;


public class MergeKSortedList {
    /*
     * TC: O(N * log(k))
     * SC: O(k)
     */
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);

        for(ListNode list: lists) {
            if(list!=null)
                pq.add(list);
        }

        while(!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;

            if(min.next!=null)
                pq.add(min.next);
        }

        return dummy.next;
    }
}

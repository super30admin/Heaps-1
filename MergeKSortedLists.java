public class MergeKSortedLists {


    /*
    TC : O(Nk * log(k)) as we iterate over Nk numbers and the heap will have maximum k members in it
    SC : O(k)
     */

    /**
     * Here we use a min heap where we add the head of all the lists in the heap. We will then have the minimum element at the
     * top of the heap. We pop this element and add it our final list.
     * We then move fowards by one step in that particular list. Here, we use a heap of ListNodes and that is how we have the reference of the list
     * from which the minimum element was obtained.
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }

        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;

            if (min.next != null)
                pq.add(min.next);

        }

        return dummy.next;
    }
}

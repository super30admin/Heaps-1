import java.util.PriorityQueue;

//23. Merge k Sorted Lists
//TC: O(nklognk)
//SC: O(k)

class mergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);//Representation of min heap
        //add head of each linkedlist to pq
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            ListNode minPolled = pq.poll();
            curr.next = minPolled;//Attaching mininum to the merged list
            if (minPolled.next != null) {
                pq.add(minPolled.next);
            }
            curr = curr.next;
        }
        //dummy.next will be the whole linkedlist ((-1) → 1 → 2 → 3 → 4 → 5 → 6)
        return dummy.next;
    }
}
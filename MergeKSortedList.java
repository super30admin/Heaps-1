class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (ListNode head : lists) {
            while (head != null) {
                heap.add(head.val);
                head = head.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (!heap.isEmpty()) {
            head.next = new ListNode(heap.remove());
            head = head.next;
        }

        return dummy.next;

    }
}
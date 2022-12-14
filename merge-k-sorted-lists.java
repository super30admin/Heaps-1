//tc is O(nklogk)
//sc is O(k)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list); // this built the min Heap with the head of the lists

            }
        }

        while (!pq.isEmpty()) {
            ListNode min = pq.poll();

            if (min != null) {
                curr.next = min;

                if (min.next != null) {
                    pq.add(min.next);
                }

                curr = curr.next;
            }
        }

        return dummy.next;

    }
}
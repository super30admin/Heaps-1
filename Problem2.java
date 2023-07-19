
// Time Complexity - 0(nk logk)
// Space Complexity - 0(k)
import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            if (min.next != null) {
                pq.add(min.next);
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
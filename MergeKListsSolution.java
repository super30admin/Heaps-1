/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeKListsSolution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        ListNode current = dummy;
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            current.next = min;
            if (min.next != null) {
                pq.add(min.next);
            }
            current = current.next;
        }
        return dummy.next;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode  head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        ListNode newHead = new ListNode(-1);
        ListNode curr = newHead;
        while(!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null) {
                pq.add(min.next);
            }
        }
        return newHead.next;
    }
}
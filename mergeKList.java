// Time Complexity :nklogk
// Space Complexity :k
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.add(lists[i]);
            }

        }
        while (!minHeap.isEmpty()) {
            ListNode qnode = minHeap.poll();
            curr.next = qnode;
            if (qnode.next != null) {
                minHeap.add(qnode.next);
            }
            curr = curr.next;
        }
        return head.next;
    }
}
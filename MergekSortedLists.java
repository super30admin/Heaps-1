// Time Complexity: O(N)  N- Total no of nodes.
// Space Complexity: O(n) n - Number of lists

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode result = new ListNode();
        ListNode head = result;

        for (int i = 0; i < lists.length; i++)
            if (lists[i] != null)
                pq.add(lists[i]);

        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            if (curr.next != null)
                pq.add(curr.next);
            head.next = curr;
            head = head.next;
        }

        return result.next;

    }
}
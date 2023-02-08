// Time Complexity : O(nklogk)
// Space Complexity : O(nk)

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(-1);
        ListNode current = result;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        while (!pq.isEmpty()) {
            ListNode minimum = pq.poll();
            current.next = minimum;
            current = current.next;

            if (minimum.next != null) {
                pq.add(minimum.next);
            }
        }

        return result.next;
    }
}
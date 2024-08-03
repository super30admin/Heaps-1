/**
 * TC: O(N log k)
 * N - total number of Nodes, K total linkedLists
 * SC: O(k)
 */


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode list: lists) {
            if(list != null) {
                pq.add(list);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while(!pq.isEmpty()) {
            ListNode popNode = pq.poll();
            current.next = popNode;
            current = current.next;

            if(current.next != null) {
                pq.add(current.next);
            }
        }
        return dummy.next;

    }
}

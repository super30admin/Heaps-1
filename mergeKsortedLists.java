//time O(nk Log k) where n is the average number of elements in a list and k is number of lists
//space O(k) priority queue space
//approach: put the heads of each list in PQ. Then poll the top element from PQ and append to dummy node. Then push the next node of earlier polled node in the PQ and repeat while the PQ is not empty. Return dummy.next in the end.


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list: lists) {
            ListNode head = list;
            if(head != null) {
                pq.add(head);
            }
        }
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            if(minNode.next != null) {
                pq.add(minNode.next);
            }
            curr.next = minNode;
            curr = curr.next;
        }
        return dummy.next;
    }
}

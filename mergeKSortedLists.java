//This code uses a min-heap (priority queue) to efficiently keep track of the smallest head node among the k linked lists. It always extracts the minimum node and pushes its next node into the heap, building the merged list in sorted order.
//Time complexity: O(N log k)
//Space Complexity: O(k)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode head: lists) {
            if(head != null) {
                pq.add(head);
            }
        }
        while(!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            if(min.next != null) {
                pq.add(min.next);
            }
            curr = curr.next;
        }
        return result.next;
    }
}
//Time Complexity : O(nklognk)
//Space  Complexity : O(k)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // PriorityQueue with custom comparator for sorting ListNodes
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each list to the priority queue
        for (ListNode list : lists) {
            if (list != null) { // Fix: Check each list, not the whole array
                pq.add(list);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if (min.next != null) {
                pq.add(min.next);
            }
        }

        return dummy.next;
    }
}
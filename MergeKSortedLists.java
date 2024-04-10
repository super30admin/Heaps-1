import java.util.PriorityQueue;

// Store all heads of linked list and add it to priority queue. pop the min element, add it to new result LL, add next ele to queue
// Repeat this process until the queue is empty
// TC - O(Nlogk) N - nk where n is the avg length of list and k is the number of lists
// sc - O(N) since we're creating and storing all the elements in LL
class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        while (pq.size() > 0) {
            ListNode minNode = pq.poll();
            cur.next = minNode;
            cur = cur.next;
            if (minNode.next != null) pq.add(minNode.next);
        }

        return dummy.next;
    }
}
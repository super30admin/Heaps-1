import java.util.PriorityQueue;
/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.
Approach - We put the first node of every list into a min-heap.
Each time we pull out the smallest node and add its next to the heap.
That way, we're always getting the next smallest node to our merged list.
Time Complexity - O(n * log k) where n is total number of nodes and k is number of lists
Space Complexity - O(k) for the heap size
 */

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            cur.next = min;
            cur = cur.next;
            if (min.next != null) {
                pq.add(min.next);
            }
        }
        return dummy.next;
    }
}

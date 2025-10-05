import java.util.Comparator;
import java.util.PriorityQueue;

//TC: O(nlogk), n: total nodes, k = elements in the list nodes
//SC: O(k)
//Approach: We can tackle this problem in 3 ways
//1. Put the elements of all the lists in an array list, sort the array list, TC: O(NlogN), SC: O(N)
//2. Merge each list with the current result list, TC: O(nk^2), SC: O(1)
//3: Since all the list nodes are sorted, we will put them all in the heap,
// take the smallest element from each and move that to its next element, put the next in the heap (We take this approach)
public class MergeKSortedLists {

    public static class ListNode {
        private int value;
        private ListNode next;

        private ListNode(int value) {
            this.value = value;
        }
    }

    public ListNode mergeKLists(final ListNode[] lists) {
        final PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        for (final ListNode listNode: lists) pq.offer(listNode);

        final ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            current.next = min;
            current = current.next;

            if (min.next != null) pq.offer(min.next);
        }

        return dummy.next;
    }
}

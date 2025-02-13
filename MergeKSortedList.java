import java.util.PriorityQueue;

/**
 * Time Complexity: O(nklogk) - nk total elements and depth is logk
 * Space Complexity: O(k), where k is the number of lists
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None
 *
 * Approach:
 * Pick each list and put into min heap, and then add min to the final list
 */
public class MergeKSortedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);

        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            if (min.next != null) {
                pq.add(min.next);
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // Your code here
    }
}

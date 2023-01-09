import java.util.*;

// Approach: Maintain a k (no. of lists) size Min heap and add the poll() node to result
// list every time and move pointer of added node to next
// Time: O(N*logk) where N = no. of nodes in final result linked list
// Space: O(n + k)
class Merge_k_sorted_lists {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode head : lists) {
            if (head != null) pq.add(head);
        }

        ListNode result = new ListNode(-1);
        ListNode curr = result;

        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if (min.next != null) {
                pq.add(min.next);
            }
        }
        return result.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
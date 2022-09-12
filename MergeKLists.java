import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        // Time complexity: nkLog(nk)
        // Space: O(k)
        if (lists == null || lists.length == 0)
            return null;
        PriorityQueue<ListNode> pQueue = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (ListNode head : lists) {
            if (head != null)
                pQueue.add(head);

        }
        while (!pQueue.isEmpty()) {
            ListNode node = pQueue.poll();
            curr.next = node;
            if (node.next != null)
                pQueue.add(node.next);
            curr = curr.next;
        }

        return dummy.next;
        /*
         * ListNode merged = new ListNode(Integer.MIN_VALUE);
         * for(ListNode li : lists)
         * {
         * merged = merge(merged,li);
         * }
         * 
         * return merged;
         */
    }

    // for merge:
    // to find time complexity:
    // if average list size is n and we have k lists:
    // after first merge we have n elements, then these n are merged with 2nd list
    // it comes 2nd elements, 3n 4n, ...kn
    // since we are iterating through k lists so Time Complexity: k*kn = k^2n
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        if (head1 != null) {
            curr.next = head1;
        }
        if (head2 != null) {
            curr.next = head2;
        }

        return result.next;
    }
}

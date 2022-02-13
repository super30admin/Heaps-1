//  Time Complexity = O(nk*log(k))
//  Space Complexity = O(n)

import java.util.*;

public class MergeKSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        //  Put the heads of all lists in PQ

        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (!pq.isEmpty()) {
            ListNode min = pq.poll();   //  log k
            cur.next = min;

            if (min.next != null) {
                pq.offer(min.next);
            }

            cur = cur.next;
        }

        return dummy.next;
    }
}

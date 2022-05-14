import java.util.PriorityQueue;

public class Problem2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //min heap method
    // TC : O (nklogk)
    // SC : O (k)
    // where n = total numbers in list and k = number of ListNode
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

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

    //brut-force method
    // TC : O (nk)^2
    // SC : O (k)
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode merged = null;
        for (ListNode head : lists) {
            merged = merge(head, merged);
        }
        return merged;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        return dummy.next;
    }

}

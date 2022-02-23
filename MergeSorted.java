import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
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

public class MergeSorted {
    // TC O(NlogK)
    // SC O(K)
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (ListNode head : lists) {
            if (head != null) {
                q.add(head);
                head = head.next;
            }
        }
        while (!q.isEmpty()) {
            ListNode node = q.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                q.add(node.next);
            }
        }
        return dummy.next;
    }
}

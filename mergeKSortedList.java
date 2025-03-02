import java.util.PriorityQueue;
// T.C - O(nlog(k))
// S.C - O(k)

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

public class mergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            while (head != null) {
                pq.add(head);
                head = head.next;
            }
        }
        ListNode head = pq.peek();
        ListNode temp;
        while (pq.size() != 0) {
            temp = pq.poll();
            temp.next = pq.peek();
        }
        return head;
    }
}

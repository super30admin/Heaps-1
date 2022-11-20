import java.util.*;

public class Problem2 {
    public static class ListNode {
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

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode curr = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int k = 0; k < lists.length; k++) {
            if (lists[k] != null)
                pq.add(lists[k]);
        }

        while (true) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            if (pq.isEmpty()) {
                break;
            }
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0, new ListNode(1, new ListNode(5)));
        ListNode l2 = new ListNode(2, new ListNode(3, new ListNode(4)));
        ListNode result = mergeKLists(new ListNode[] { l1, l2 });
        while (result.next != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
        System.out.print("null");
    }
}
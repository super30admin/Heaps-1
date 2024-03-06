// Time complexity: O(nlogk) where n = all elements combined in the linked list
// Space complexity: O(k)

// Approach: Add all the heads of the linked lists in a heap. Keep popping and adding
// the next element of the minimum and make "next" connections.

import java.util.PriorityQueue;
import java.util.Queue;

public class KSortedLists {

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

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        Queue<ListNode> heap = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) {
                heap.add(list);
            }
        }

        if (heap.size() > 0) {
            res = heap.poll();
            if (res.next != null) {
                heap.add(res.next);
            }
        }

        ListNode currNode = res;

        while (!heap.isEmpty()) {
            ListNode nextNode = heap.poll();
            if (nextNode.next != null) {
                heap.add(nextNode.next);
            }
            currNode.next = nextNode;
            currNode = nextNode;
        }

        return res;
    }

}

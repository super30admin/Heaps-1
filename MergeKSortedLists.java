// Time Complexity : O(n log k) k is number of linkedlists, n is total elements
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : no
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach: min adding first elements to the pq, then iterating through the linked lists of smallest elem in heap

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

        ListNode head = new ListNode(-1);
        ListNode curr = head;

        for (ListNode ln : lists) {
            if (ln != null)
                pq.add(ln);
        }

        while (!pq.isEmpty()) {
            curr = pq.poll();
            curr = curr.next;

            if (curr.next != null) {
                pq.add(curr.next);
            }
        }
        return head.next;
    }
}

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

// Time Complexity : O(nklog(k))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package heap1;

import java.util.*;

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

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // add the listnodes to the queue
        for (ListNode head : lists) {

            if (head != null) {

                pq.add(head);
            }

        }

        // create dummy listnode to store result
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {

            ListNode min = pq.poll();
            // refer to the address of the min
            curr.next = min;
            // move the curr pointer to the min address
            curr = curr.next;

            if (min.next != null) {
                // if the min has next element add it to the queue
                pq.add(min.next);

            }

        }
        // return the result listnode list
        return dummy.next;

    }
}

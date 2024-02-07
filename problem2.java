// Time Complexity :O(n log k)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.PriorityQueue;

//  method merges k sorted linked lists efficiently into one sorted list using a priority queue
//  to select the minimum node at each step
public class problem2 {
    class Solution {
        PriorityQueue<ListNode> pq;

        public ListNode mergeKLists(ListNode[] lists) {
            pq = new PriorityQueue<>((a, b) -> a.val - b.val);
            for (ListNode head : lists) {
                if (head != null)
                    pq.add(head);
            }
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;
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
    }
}
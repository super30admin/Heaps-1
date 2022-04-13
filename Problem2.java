// Time Complexity : O(nk(log k)) where n is the length of the each list and k is the number of lists
// Space Complexity : O(k) where k is the number of lists
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode li : lists) {
            if (li != null)
                pq.add(li);
        }

        ListNode result = new ListNode(-1);
        ListNode temp = new ListNode(-1);
        ListNode curr = result;

        while (!pq.isEmpty()) {
            temp = pq.poll();
            curr.next = temp;
            curr = curr.next;
            if (temp.next != null)
                pq.add(temp.next);
        }

        return result.next;
    }
}
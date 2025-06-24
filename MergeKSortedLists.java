// Time complexity O(N log(k)) N=nk
// Space complexity O(k)
// Runs on LeetCode Yes

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        for (ListNode node : lists) {
            if (node != null) {
                q.add(node);
            }
        }

        while (!q.isEmpty()) {
            ListNode minNode = q.poll();
            curr.next = minNode;
            curr = curr.next;

            if (minNode.next != null) {
                q.add(minNode.next);
            }
        }

        return result.next;

    }
}
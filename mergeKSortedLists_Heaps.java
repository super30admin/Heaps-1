// Time Complexity : O(nlogk) where n is the number of nodes in the final LL
// Space Complexity : O(n) where n is the number of nodes in the final LL 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Heaps

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class mergeKSortedLists_Heaps {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);   
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            dummy.next = curr;
            dummy = dummy.next;
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }
        return head.next;
    }
}
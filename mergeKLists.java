/*
Problem: https://leetcode.com/problems/merge-k-sorted-lists/
TC: O(nk log k) where k is the number of lists and n is the max length of each list
*/
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
        if (lists == null || lists.length == 0)
            return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        ListNode dummy = new ListNode(-1);
        
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode n = pq.poll();
            cur.next = n;
            cur = cur.next;
            if (n.next != null) {
                pq.offer(n.next);
            }
        }
        return dummy.next;
    }
}
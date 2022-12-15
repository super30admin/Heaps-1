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
 //Time complexity is O(M) Where M = k*N, k is lists length and N is average length of each list
 //Space complexity is O(k*N) 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node != null) heap.add(node);
        }

        ListNode head = new ListNode(0);
        ListNode current = head;

        while (!heap.isEmpty()) {
            ListNode next = heap.poll();
            current.next = next;
            if (next.next != null) heap.add(next.next);
            current = current.next;
        }

        return head.next;
    }
}
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
    /*
        TC - O(n log k),  is total nodes, k is no of linked lists
        SC - O(k) - priority queue stores k nodes
        Solution - Add the first node of every non-empty linked list into a min heap.
        The heap always keeps the smallest available node at the top.
        Repeatedly remove the smallest node from the heap and add it to the merged list.
        After removing a node, insert its next node into the heap (if it exists).
        Continue until the heap becomes empty.
    */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            if (minNode.next != null) {
                pq.add(minNode.next);
            }
            curr.next = minNode;
            curr = curr.next;
        }

        return dummy.next;
    }
}
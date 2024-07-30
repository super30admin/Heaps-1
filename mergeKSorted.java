
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
// TC --> O(nlogk)
// SC --> O(k)
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode a, ListNode b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head); //O(logk)
            }

        }
        ListNode head = new ListNode();
        ListNode curr = head;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) {
                pq.add(node.next); //O(logk)
            }

        }//while
        return head.next;

    }
}

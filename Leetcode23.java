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

        // Solution 1 : Priority Queue with max k elements
        // TC - O(Nlog(k))
        // SC - log(k)
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode a, ListNode b) -> (a.val - b.val));
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        int k = lists.length;
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();

            current.next = temp;
            current = current.next;
            temp = temp.next;
            if (temp != null) {
                pq.add(temp);
            }
        }
        return dummy.next;

        // Solution - Put all elements in the PQ
        // TC - O(NlogN) where N is the count of all the elements
        // SC - O(NlogN) where N is the count of all the elements
        // PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode a, ListNode b) ->
        // (a.val - b.val));
        // for(ListNode list: lists) {
        // ListNode head = list;

        // while(head!=null) {
        // pq.add(head);
        // head = head.next;
        // }
        // }
        // ListNode dummy = new ListNode();
        // ListNode current = dummy;
        // while(!pq.isEmpty()) {
        // ListNode temp = pq.poll();
        // temp.next = null;
        // current.next = temp;
        // current = current.next;

        // }

        // return dummy.next;

    }
}
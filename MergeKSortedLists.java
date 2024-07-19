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

/***
 Using min heap
 TC - O(nklogk)
 SC - O(k)
 */
class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length ==0)
            return null;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val - b.val));

        for(ListNode node : lists) {
            if(node != null)
                pq.add(node);
        }

        while(!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;

            if(min.next != null){
                pq.add(min.next);
            }
        }

        return dummy.next;

    }
}
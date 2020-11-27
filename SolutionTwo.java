// Time Complexity :O(nk log k)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :no

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
class SolutionTwo {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);

        ListNode dummy = new ListNode(-1);

        ListNode result = dummy;

        for(ListNode head:lists)
        {
            if(head!=null)
            {
                pq.add(head);
            }
        }

        while(!pq.isEmpty())
        {
            ListNode min = pq.poll();

            dummy.next = min;

            dummy = dummy.next;

            if(min.next!=null)
                pq.add(min.next);

        }

        return result.next;
    }
}
// Time Complexity : O(Nlogk) where N total number of elements , k number of lists, n average list size N= nk
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// we use a min heap of size k and place the heads of all the lists and the min element from all the lists will be their on the top.
// we add the next element from the list from the min element list.

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
        //min heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val-b.val);
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        for(ListNode head : lists)
        {
            if(head!=null)
            {
                pq.add(head);
            }
        }
            while(!pq.isEmpty())
            {
                ListNode min= pq.poll();
                result.next = min;
                result = result.next;
                if(min.next != null)
                {
                    pq.add(min.next);
                }
            }
        return dummy.next;
    }
}
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
 // This approach uses a priority queue to hold the list of first nodes from all the given lists. It will iteratively pop the minimum elements from the heap and add it to the chain. We again add back the next element once its added to chain
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a,b)-> a.val-b.val);
        for(ListNode ls:lists) {
            if(ls!=null) pq.add(ls);
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;
        while(!pq.isEmpty()) {
            ListNode ls = pq.poll();
            curr.next = ls;
            curr = curr.next;
            if(curr.next!=null) pq.add(curr.next);
        }
        return dummy.next;
    }
}

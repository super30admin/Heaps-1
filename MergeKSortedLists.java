// Time Complexity : O(Nlogk) N-> No of Nodes in final list
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        Queue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);

        for(ListNode l : lists) {
            if(l != null)
                pq.add(l);
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;

            if(curr.next != null)
                pq.add(curr.next);
        }
        return dummy.next;
    }
}
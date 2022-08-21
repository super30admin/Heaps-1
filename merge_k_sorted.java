// Time Complexity : O(nklogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length ==0)
        {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode result= new ListNode(-1);
        ListNode curr = result;

        for(ListNode head:lists )
        {
            if(head!=null)
            {
                pq.add(head);
            }
        }
        while(!pq.isEmpty())
        {
            ListNode min =pq.poll();
            curr.next=min;
            if(min.next!=null)
            {
                pq.add(min.next);
            }
            curr=curr.next;
        }
        return result.next;
    }
}
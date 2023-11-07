// Time Complexity : O(nK*log(K))
// Space Complexity : O(nK)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: None

// Your code here along with comments explaining your approach

class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode head: lists){
            if(head!=null){
                pq.add(head);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode minNode = pq.poll();
            curr.next = minNode;
            curr=curr.next;
            if(minNode.next!=null){
                pq.add(minNode.next);
            }
        }

        return dummy.next;
    }
}
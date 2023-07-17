// Time Complexity O(nlogm)
// Space Complexity O(m)

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode dummy = new ListNode(-1);
        ListNode curr=dummy;
        for(ListNode head : lists){
            if(head != null) q.add(head);
        }
        while(!q.isEmpty()){
            ListNode min = q.poll();
            curr.next = min;
            curr=curr.next;
            if(min.next!=null) q.add(min.next);
        }
        return dummy.next;

    }
}
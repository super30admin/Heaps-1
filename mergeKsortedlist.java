class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);

        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        for(ListNode node : lists){
            if(node!=null){
                pq.add(node);
            }
        }
        while(!pq.isEmpty()){
            ListNode curr=pq.poll();
            result.next=curr;
            result=result.next;
            if(curr.next!=null){
                pq.add(curr.next);
            }
        }
        return dummy.next;
    }
}
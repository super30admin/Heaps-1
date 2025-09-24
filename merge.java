class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode l:lists){
            if(l!=null){
                pq.add(l);
            }
        }
            ListNode dummy=new ListNode(-1);
            ListNode curr=dummy;
            while(!pq.isEmpty()){
                ListNode min=pq.poll();
                if(min.next!=null){
                    pq.add(min.next);
                }
                curr.next=min;
                curr=curr.next;
            }
            return dummy.next;
    }
}
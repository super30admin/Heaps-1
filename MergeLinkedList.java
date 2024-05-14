package Heaps-1;

public class MergeLinkedList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val-b.val);
        for (ListNode li: lists){
            if(li!=null) pq.add(li);
        }

        ListNode result = new ListNode(-1);
        ListNode current = result;
        while(!pq.isEmpty()){
            ListNode currentMinimum = pq.poll();
            current.next = currentMinimum;
            current = current.next;

            if(currentMinimum.next!=null){
                pq.add(currentMinimum.next);
            }
        }

        return result.next;
    }
}

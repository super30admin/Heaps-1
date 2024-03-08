import solutions.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    //TC: O(Nlog(k))
    //SC: O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)->a.val-b.val);//min heap
        ListNode dummy = new ListNode(-1);
        for(ListNode head: lists){
            if(head!=null){
                pq.add(head);
            }
        }
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next!=null){
                pq.add(min.next);
            }
        }
        return dummy.next;
    }
}

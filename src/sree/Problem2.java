package sree;

import java.util.PriorityQueue;

public class ListNode {     int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Problem2 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq= new PriorityQueue<>((a,b)-> a.val- b.val);
        for(ListNode li: lists){
            if(li!=null){
                pq.add(li);
            }
        }
        ListNode dummy= new ListNode(-1);
        ListNode curr= dummy;
        while(!pq.isEmpty()){
            ListNode min= pq.poll();
            curr.next= min;
            curr= curr.next;
            if(min.next!=null){
                pq.add(min.next);
            }
        }
        return dummy.next;
    }
}

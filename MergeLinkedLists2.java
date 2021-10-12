package Heaps1;
// Time Complexity : O(Nklog(k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes

import LinkedList1.ListNode;

import java.util.PriorityQueue;

public class MergeLinkedLists2 {
    public ListNode mergeKLists(ListNode[] lists) {
            ListNode res = new ListNode(-1);
            ListNode curr = res;
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
            for(ListNode l : lists){
                if(l != null)
                    pq.add(l);
            }
            while(pq.size() > 0){
                ListNode elem = pq.poll();
                if(elem.next != null)
                    pq.add(elem.next);
                curr.next = elem;
                curr = curr.next;
            }
            return res.next;
    }
}

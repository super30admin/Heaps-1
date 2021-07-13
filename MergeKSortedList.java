package Heaps1;

public class MergeKSortedList {
	   // Time complexity - O(nk log k) - nk: number of elements, log k- sort PriorityQ/heapify
    // Space complexity - O(k) - number of elements in PriorityQ
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val-b.val);
        for(ListNode list:lists){
            if(list!= null)
                pq.add(list);
        }

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(pq.size()!= 0){
            ListNode min = pq.poll();
            dummy.next = min;
            dummy = dummy.next;
            if(min.next!= null){
                min = min.next;
                pq.add(min);
            }
        }
        return head.next;
    }
}
}

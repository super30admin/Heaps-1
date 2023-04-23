import java.util.PriorityQueue;

public class MergeKsortedLL {

    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
//NlogK
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode head : lists) {
            if(head != null) {
                pq.add(head);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null) {
                pq.add(min.next);
            }
        }
        return dummy.next;
    }

    //O(NK)
    /*public ListNode mergeKLists(ListNode[] lists) {
        ListNode mergedll = new ListNode(Integer.MIN_VALUE);
        for(ListNode li : lists) {
            if(li!=null)
                mergedll = merge(mergedll, li);
        }
        return mergedll.next;
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode p1 = n1;
        ListNode p2 = n2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                curr.next = p1;
                p1 = p1.next;
            } else {
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next;
        }
        if(p2 != null) {
            curr.next = p2;
        }
        if(p1 != null) {
            curr.next = p1;
        }
        return dummy.next;
    }*/
}

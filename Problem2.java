/*
Merge K Sorted Lists
approach: add all the heads of the linked lists to the min heap, pop min node, add next node if it's not null, repeat
time: O(N log k)
space: O(k)
 */
public class Problem2 {
/*
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(-1);
        PriorityQueue<ListNode> q =  new PriorityQueue<>((a, b)->(a.val-b.val));
        for(ListNode node: lists) {
            if(node!=null)
                q.add(node);
        }

        ListNode curr = res;
        while(!q.isEmpty()) {
            ListNode popped = q.poll();
            curr.next = popped;
            curr = curr.next;
            popped = popped.next;
            if(popped!=null)
                q.add(popped);
        }

        return res.next;
    }

        private ListNode merge(ListNode h1, ListNode h2) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;

        while(h1!=null && h2!=null) {
            if(h1.val<h2.val) {
                cur.next = h1;
                cur = cur.next;
                h1 = h1.next;
            }
            else {
                cur.next = h2;
                cur = cur.next;
                h2 = h2.next;
            }
        }
        if(h1!=null) cur.next = h1;
        if(h2!=null) cur.next = h2;
        return res.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
    ListNode merged = new ListNode(Integer.MIN_VALUE);
        for(ListNode node:lists) {
            merged = merge(merged, node);
        }

        return merged.next;
    }

 */
}

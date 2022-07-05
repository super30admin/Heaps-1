//Time complexity : O(Nlogk) where k is the number of linked lists.
// Space Complexity: O(k)
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode list: lists){
            if(list!=null)
                pq.add(list);
        }

        ListNode result = new ListNode();
        ListNode curr = result;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next!=null)
                pq.add(min.next);

        }
        return result.next;
    }
}

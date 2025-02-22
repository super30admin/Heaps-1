
// Time Complexity: O(nmlognm)
// Space Complexity: O(nm)

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists== null || lists.length ==0){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode list : lists){
            if(list != null){
                pq.add(list);
            }
        }
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            if(min.next != null){
                pq.add(min.next);
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}

public class MergeKSortedList {
    // TC is nlogk where k is the number of lists and n is the number of nodes
    // SC is O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode node: lists){
            if(node != null){
                pq.add(node);
            }
        }
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null){
                pq.add(min.next);
            }
        }
        return result.next;
    }
}

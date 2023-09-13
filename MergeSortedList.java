// TC = nk(log(k))
// SC = O(k)
// Here we are using Heap to merge and sort.
class MergeSortedList{
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a,b) -> (a.val-b.val));
        for(ListNode head : lists){
            if(head !=  null){
                pq.add(head);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null){
                pq.add(min.next);
            }
        }
        return dummy.next;        
    }
}
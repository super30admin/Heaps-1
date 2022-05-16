//time - O(nklogk) k = number of LinkedLists, n - avg number of nodes in each linkedlist
//space - O(k)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val - b.val);

        for(ListNode head : lists){
            if(head!=null)
                pq.add(head);
        }

        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next!=null)
                pq.add(min.next);
        }

        return dummy.next;
    }
}

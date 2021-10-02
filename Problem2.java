//Time complexity: O(nlogk)
//Space complexity: O(k)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->(a.val-b.val));
        for(ListNode li : lists){
           if(li != null) pq.add(li);
        }
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next !=null){
                System.out.println(min.next.val);
                pq.add(min.next);
            }
        }
        return dummy.next;
    }
}
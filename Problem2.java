public class Problem2 {
    class Solution {
        PriorityQueue<ListNode> pq ;
        public ListNode mergeKLists(ListNode[] lists) {
            pq = new PriorityQueue<>((a,b) -> a.val - b.val);
            for(ListNode head: lists){
                if(head != null)
                    pq.add(head);
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

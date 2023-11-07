//Time  Complexity: O(nlogk)
//Space Complexity: O(k)

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode head: lists){
            if(head!=null){
                pq.add(head);
            }
        }
        ListNode d = new ListNode(-1);
        ListNode current = d;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            current.next =min;
            current = current.next;
            if(min.next!=null){
                pq.add(min.next);
            }
        }
        return d.next; 
    }
}

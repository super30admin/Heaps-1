class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(ListNode listnode : lists){
            while(listnode!=null){
                pq.add(listnode.val);
                listnode = listnode.next;
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        
        while(!pq.isEmpty()){
            head.next = new ListNode(pq.remove());
            head = head.next;
        }
        
        return dummy.next;
    }
}
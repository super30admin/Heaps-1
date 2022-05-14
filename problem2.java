class mergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        for(ListNode head : lists){
            if(head != null){
                pq.add(head);
            }
        }
        
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

//time complexity O(nklogk) where n is number of list and k is average length of each list
//space complexity O(k)
//TC - O(nlog(k))
//SC - O(k)

class Solution1 {
    ListNode res = new ListNode(-1);
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(ListNode l : lists)
        {
            if(l != null)
                pq.add(l);
        }
        
        ListNode dummy = res;
        
        while(!pq.isEmpty())
        {
            ListNode l1 = pq.poll();
            dummy.next = l1;
            
            if(l1.next != null)
                pq.add(l1.next);
            
            dummy = dummy.next;
        }
        
        return res.next;
    }
}

//TC - O(kn)
//SC - O(k)

class Solution2 {
    
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        
        for(ListNode l : lists)
            merged = merge(merged, l);
        
        return merged.next;
    }
    
    private ListNode merge(ListNode l1, ListNode l2)
    {
        ListNode res = new ListNode(-1);
        ListNode dummy = res;
        
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                dummy.next = l1;
                dummy = dummy.next;
                l1 = l1.next;
            }
            else
            {
                dummy.next = l2;
                dummy = dummy.next;
                l2 = l2.next;
            }
        }
        
        if(l2 == null)
            dummy.next = l1;
        if(l1 == null)
            dummy.next = l2;
        
        return res.next;
    }
}

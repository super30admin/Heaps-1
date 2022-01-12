// Time Complexity: insertion in heap initally O(k) + make new list O(nk) + insertion new list O(nklogk)->O(nklogk) 
// Space Complexity: O(k)
// Heap 
public class  MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0)
        return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(ListNode list : lists)
        {
            if(list != null) // since null LL are allowed
                pq.offer(list);
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(!pq.isEmpty())
        {
           ListNode minLL = pq.poll();
           curr.next = minLL;
           if(minLL.next != null)
           {
               pq.offer(minLL.next);
           }
           curr = curr.next;
        }


        return dummy.next;

    }
}

// Time Complexity: O(nk)^2 -> k LL with n elements happens 
// Space Complexity: O(nk) space for dummy list
// brute force
public class  MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        
        ListNode dummy = null;
        
        for(ListNode list : lists)
        {
            dummy = merge(dummy, list);
        }
        
        return dummy;
    }
    
    private ListNode merge(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                curr.next = l1;
                l1 = l1.next;
            }
            else
            {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        if(l1 != null)
        {
            curr.next = l1;
        }
        
        if(l2 != null)
        {
            curr.next = l2;
        }
        
        return dummy.next;
    }
}

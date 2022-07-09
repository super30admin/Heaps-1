class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Heapify heads
        // Best TC - O(nlog(k))
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val); // min heap
        for (ListNode head : lists){
            if (head != null){
                pq.add(head);
            }
        }
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        
        while (!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = min; // or curr = curr.next
            if (min.next != null){
                pq.add(min.next);
            }  
        }
        return result.next;  
    }
}

/*
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Add 2 lists then next 
        // TC - O(nk)
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        for (ListNode li : lists){
            merged = merge(li,merged);
            }
        return merged.next;
    }
    private ListNode merge(ListNode h1, ListNode h2){
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        while (h1 != null && h2 != null){
            if (h1.val <h2.val){
                curr.next = h1;
                h1 = h1.next;
            }
            else{
                curr.next = h2;
                h2 = h2.next; 
            }
            curr = curr.next;
        }
        if (h2 != null){
            curr.next = h2;
        }
        if (h1 != null){
            curr.next = h1;
        }
        return result.next; 
    }
}
*/
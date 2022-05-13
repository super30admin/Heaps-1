// Time Complexity : O(nlogk)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We can Build max heap, then Remove element k times
//Kth removed element is the result
// TC: O(nlogn + klogn) -> nlogn is to build tree, klogn is for removal.
//so we can optimize the above approach to maintain only k elements at a time '
// Whenever we inset new element we check min heap condition and number of elements shoulebe less than k. 
// Run swap and removal accordingly.
 public ListNode MergeKLists(ListNode[] lists) {
    if(lists == null || lists.Count() == 0)
        return null;
    
    ListNode merged = null;
    foreach(ListNode head in lists)
    {
        merged = merge(merged, head);
    }
    
    return merged;
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
        curr.next = l1;
    else if(l2 != null)
        curr.next = l2;
    
    return dummy.next;
}





//using min heap - priprioty queue
public ListNode MergeKLists(ListNode[] lists) {
    if(lists == null || lists.Count() == 0)
        return null;
    
    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;
    PriorityQueue<ListNode, int> pq = new PriorityQueue<ListNode, int>();
    
    foreach(var head in lists)
    {
        if(head != null)
            pq.Enqueue(head, head.val);
    }
    
    while(pq.Count > 0)
    {
        var list = pq.Dequeue();
        ListNode min = new ListNode(list.val);
        curr.next = min;
        curr = curr.next;
        if(list.next != null)
            pq.Enqueue(list.next, list.next.val);
    }
    return dummy.next;
}

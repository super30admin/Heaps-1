// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) { val = x; }
//  * }
//  */

// // TC: O(NlogK);
// // SC: O(K)
// // Did it run successfully on Leetcode? : Yes

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if ( lists == null || lists.length == 0)
            return null;
        
       PriorityQueue<ListNode> pq = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
        for ( ListNode list : lists)
        {
            if (list != null)
              pq.add(list);
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode result = dummy; 
        while (!pq.isEmpty())
        {
            ListNode minimum = pq.poll();
            result.next = minimum;
            result = result.next;
            if (minimum.next != null)
                pq.add(minimum.next);
        }
        return dummy.next;
    }
}


// // TC: O(N * (K ^ 2));
// // SC: O(1)
// // Did it run successfully on Leetcode? : Yes
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if ( lists == null || lists.length == 0)
            return null;
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode merged = dummy; 
        for ( ListNode list : lists)
        {
            merged = mergeTwoLists(merged, list);     
        }
        return dummy.next;
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        while ( l1 != null && l2 != null)
        {
            if ( l1.val <= l2.val)
            {
                result.next = l1;
                l1 = l1.next;
            }
            else 
            {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }
         if ( l1 != null)
            result.next = l1;
        
         if ( l2 != null)
            result.next = l2;
        
         return dummy.next;
    }
}

// TC: O(N * logK) - N -> Total no. of elements in the final sorted list, K -> no. of linked lists
// SC : O(1)
// Did it run successfully on Leetcode? : Yes
class Solution{
public ListNode mergeKLists(ListNode[] lists) {
    if ( lists == null || lists.length == 0)
        return null;
    int interval = 1;
    while ( interval < lists.length)
    {
        for ( int i = 0; i + interval < lists.length; i = i + 2*interval)
        {
            lists[i] = mergeTwoLists(lists[i], lists[i + interval]);   //0 = merge(0,1)       2=merge(2,3)   then 0 = merge(0,2)      
        }
        interval = interval * 2;
    }
    return lists[0];
  
}
private ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        while ( l1 != null && l2 != null)
        {
            if ( l1.val <= l2.val)
            {
                result.next = l1;
                l1 = l1.next;
            }
            else 
            {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }
         if ( l1 != null)
            result.next = l1;
        
         if ( l2 != null)
            result.next = l2;
        
         return dummy.next;
    }
}

// ## Problem2 Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)

// Time Complexity : O(Nlog k) [N is total number of elements after adding all lists, k is number of lists]
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

// Heaps more efficient

// approach: we put all the first element of the different lists in a min heap, remove the root element (minimum), add to the output list and then add the element next to the element removed (from the original list), to the heap.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists ==null || lists.length ==0)
        {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for(ListNode list: lists)
        {
            if(list!= null)
            {
                pq.add(list);
            }
        }


        while(!pq.isEmpty())
        {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next!=null)
            {
                pq.add(min.next);
            }
        }
        return dummy.next;
        
    }
}



//merging 2 lists  at a time (less eficient)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if( lists == null || lists.length==0)
        {
            return null;
        }

        ListNode merged = new ListNode(Integer.MIN_VALUE);
        
        for(ListNode list: lists)
        {
            merged = merge(merged,list);
        }

        return merged.next;
        
    }

    public ListNode merge(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(l1!=null && l2!=null)
        {
            if(l1.val<l2.val)
            {
                curr.next=l1;
                l1=l1.next;
                
            }
            else
            {
                curr.next=l2;
                l2=l2.next;
                
            }
            curr=curr.next;
        }
        while(l1!=null)
        {
            curr.next=l1;
            l1=l1.next;
            curr=curr.next;
        }
        while(l2!=null)
        {
            curr.next=l2;
            l2=l2.next;
            curr=curr.next;
        }

        return dummy.next;
    }
}

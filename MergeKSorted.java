// Time Complexity:O(nlogk)
// Space Complexity: O(k)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this:No


// Your code here along with comments explaining your approach
/*
 * In this approach, we are adding the heads of each of the LL to the minHeap. After that, we poll the minimum and
 * check if the polled minimum has a next node. If yes, we add the next node of the polled minimum.
 * We then build a resultant LL of the polled minimums
 */

import java.util.PriorityQueue;

public class MergeKSorted {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val - b.val));
        
        for(ListNode head:lists)
        {
            if(head != null)
            {
                pq.add(head);
            }
        }
        
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        while(!pq.isEmpty())
        {   
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            
            if(min.next != null)
            {
                pq.add(min.next);
            }
        }
        return result.next;
    }
}

/*
 * Approach 2 - Merging 1st two lists using their heads and then using this merged list to merge with the
 * third list and so on.
 */
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        for(ListNode li:lists)
        {
            merged = merge(li,merged);
        }
        return merged.next;
    }
    
    public ListNode merge(ListNode h1, ListNode h2)
    {
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        while(h1 != null && h2 != null)
        {   
            if(h1.val < h2.val)
            {
                curr.next = h1;
                h1 = h1.next;
            }
            else
            {
                curr.next = h2;
                h2 = h2.next;
            }
            curr = curr.next;
        }
            if(h1 != null)
            {
                curr.next = h1;
            }
            if(h2 != null)
            {
                curr.next = h2;
            }
        return result.next;
    }
}

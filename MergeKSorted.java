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

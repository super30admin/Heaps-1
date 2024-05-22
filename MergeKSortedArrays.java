// Time Complexity : Nlog(k)
// Space Complexity : k
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : Yes. still getting around the initution.

/*
 * Add all elements to a PriorityQueue(min heap)
 * Keep adding K nodes
 * while pq is not empty
 * pop the currmin; add it to result linkedlist ; if currMin.next is not null add the next node to priorityqueue.
 *  
 * 
 */

import java.util.PriorityQueue;

public class MergeKSortedArrays {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val); // bring a to front min heap

        for (ListNode li : lists) {
            if (li != null) {
                pq.add(li);
            }

        }

        ListNode result = new ListNode(-1);
        ListNode curr = result;

        while (!pq.isEmpty()) {
            ListNode currMin = pq.poll();
            curr.next = currMin;
            curr = curr.next;
            if (currMin.next != null) {
                pq.add(currMin.next);
            }
        }
        return result.next;

    }

}
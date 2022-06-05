
//Time Complexity: O(NK * LogK)
//Space Complexity: O(K)

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
        // we are going to sort the nodes upon its value
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        // load the first Head of all the lists
        for(ListNode li: lists) {
            if(li != null)
                pq.add(li);
        }
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        // now start traversing from top of the heap
        while(!pq.isEmpty()) {
            // we remove the head of the queue
            ListNode min = pq.poll();
            // add it to our result
            curr.next = min;
            // making sure the connecting happens in result list
            curr = curr.next;
            // unti the list runs into next being null,
            // we keep adding it to our minHeap queue
            if(min.next != null) {
                pq.add(min.next);
            }
        }

        return result.next;
    }
}
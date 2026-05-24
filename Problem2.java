// https://leetcode.com/problems/merge-k-sorted-lists/
// Time Complexity : O(N log k) where N is the average number of nodes in each list and k is the number of lists;
// Space Complexity : O(k) where k is the number of lists;
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Approach : Use a min-heap to merge k sorted lists.
 *            The heap will store the smallest elements from each list.
 *            We will keep adding the next element from the list whose 
 *            element was removed from the heap until the heap is empty.
 */


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        for(ListNode list : lists){
            if(list != null){
                pq.add(list);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next!= null){
                pq.add(min.next);
            }
        }
        return dummy.next;
    }

}
// Time Complexity: O(nk log k)
// Space Complexity: O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // initialize dummy node to which the final sorted list will be appended
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        // initialize priority queue
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        // iterate through the list, keep adding to prority queue
        for(ListNode li : lists){
            if(li != null) pq.add(li);
        }
        // Until prioirity queue gets empty, keep removing the minimum node
        // keep adding the node to current.next
        // whichever node has given the minimum value, add its next node to inside priority queue
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            current.next = min;
            current = current.next;
            if(min.next != null) pq.add(min.next);
        }
        return dummy.next;
    }
}
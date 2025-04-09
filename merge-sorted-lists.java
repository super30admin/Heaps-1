//Time Complexity:O(n*mlog(n*m))
//Space Complexity:O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (ListNode head : lists) {
            while (head != null) {
                minHeap.add(head.val);
                head = head.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Remove the smallest elements from the heap one by one and create new list nodes
        while (!minHeap.isEmpty()) {
            current.next = new ListNode(minHeap.remove());
            current = current.next;
        }

        // Return the merged list, which starts after the dummy node
        return dummy.next;
    }
}

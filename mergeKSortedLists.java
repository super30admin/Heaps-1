// Time complexity = O(n * k * log k), where n is average no of elements in each list, k = no. of lists
// Space complexity = O(k), for the min heap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);

        // load the pq with the first element in the lists (Singly linked list)
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        // poll each element (min element) from pq and form the result list
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            if (min.next != null) {
                pq.add(min.next);
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
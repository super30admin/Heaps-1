// Time Complexity : o(nlogn)
// Space Complexity : o(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val); // creating min heap
        ListNode dummy = new ListNode(-1); // dummy node
        ListNode curr = dummy; // setting current to dummy, so we can retur this at the end
        for (ListNode list : lists) { // adding the head of each lists here
            if (list != null) {
                pq.add(list);
            }
        }
        while (!pq.isEmpty()) { // traverse till list aint empty
            ListNode min = pq.poll(); // get the smallest element
            curr.next = min; // move forward
            curr = curr.next; // set current forward
            if (min.next != null) { // check if there is something in the list of the element you traversed.
                pq.add(min.next);
            }
        }

        return dummy.next; 
    }
}
/*
    LC - 23. Merge k Sorted Lists
    TC - O(nk log k)
    SC - O(k)
    Approach - Using ListNode pointer, and min heap, add element (inital 3 listnodes) in the queue then poll and append the node to the result. Add the next node of the min element in the queue
*/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val); // creating min heap
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for(ListNode list: lists) {
            if(list != null) {
                pq.add(list);
            }
        }
        while(!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null) {
                pq.add(min.next);
            }
        }
        return dummy.next;
    }
}
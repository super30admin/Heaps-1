// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to use a min heap as we want to sort the min elements first.We iterate through the input array of
lists and offer them to our heap.We maintain a dummy node for easier access of result to return.Now, we want
to iterate until the end of the heap where the minimum element of the list automatically appears at the top because
of the heap property and we want to use that node to connect to our dummy and so on for our current nodes. We traverse
that particular list whose element gets polled at the top of the heap and add iteratively to our heap. This way
we can form the result linked list.
 */
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
        Queue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode list : lists) {
            if(list != null)
                pq.offer(list);
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;

            if(min.next != null)
                pq.offer(min.next);
        }
        return dummy.next;
    }
}
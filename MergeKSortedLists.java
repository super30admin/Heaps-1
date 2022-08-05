import java.util.PriorityQueue;

//Time complexity: O(nlogk)
//Space complexity: O(k) , Heap space 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        // min heap solution
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val); // min heap
        ListNode dummy = new ListNode(-1); // to create the result LL
        ListNode curr = dummy;

        // creating a heap with all the heads of the LL's , if k lists are present, then
        // min heap of size k
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        // removing the min element of the heap and adding it to the linked list.
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min; // adding it to the linkedlist
            if (min.next != null) {
                pq.add(min.next);
            }
            curr = curr.next; // updating the curr in the LL to the latest node.

        }
        return dummy.next;

    }
}
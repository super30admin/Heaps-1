package Heaps1;

import java.util.PriorityQueue;

/*
 -------------------------------------------------------------------------------------------------------
 Time complexity : n*k log k -where is n is the average number of elements in single linked list and k is the number of linked lists
 space complexity: o(k) - max size of priority queue, which is number of linked lists
 Did this code run successfully in leetcode : yes
 problems faces : no
 */

public class MergeKSortedListWithMinHeap {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;

        for (ListNode headNode : lists) {
            if (headNode != null) {
                pq.add(headNode);
            }
        }

        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            current.next = min;
            current = current.next;
            if (min.next != null) {
                pq.add(min.next);
            }

        }
        return dummyNode.next;
    }

}

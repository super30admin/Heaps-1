package Heaps1;

import java.util.PriorityQueue;

public class question81_MergekSortedLists {
    /* Created by palak on 7/6/2021 */

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     Time Complexity: O(n log n)
     Space Complexity: O(n)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(ListNode list: lists) {
            while(list != null) {
                pq.add(list.val);
                list = list.next;
            }
        }
        ListNode temp = new ListNode(-1);
        ListNode prev = temp;
        while(!pq.isEmpty()) {
            temp.next = new ListNode(pq.remove());
            temp = temp.next;
        }
        return prev.next;
    }
}
// Time Complexity : O((N * log(k)) [N: ∑(n); k: lists.size(); n: number of nodes in each List Node]
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.PriorityQueue;

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

        if (lists == null || lists.length == 0) {
            return null;
        }

        // return divideNConquerhelper(lists, 0, lists.length -1);
        // return helperBruteForce(lists);
        return helperMinHeap(lists);
    }

    private ListNode helperMinHeap(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            if (min.next != null) {
                pq.add(min.next);
            }
            curr.next = min;
            curr = curr.next;
        }
        return dummy.next;
    }

    private ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                list2.next = mergeTwoList(list1, list2.next);
                return list2;
            } else {
                list1.next = mergeTwoList(list1.next, list2);
                return list1;

            }
        }

        if (list1 == null) {
            return list2;
        } else {
            return list1;
        }
    }

    private ListNode divideNConquerhelper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;
        ListNode leftNode = divideNConquerhelper(lists, start, mid);
        ListNode rightNode = divideNConquerhelper(lists, mid + 1, end);
        return mergeTwoList(leftNode, rightNode);
    }

    private ListNode helperBruteForce(ListNode[] lists) {
        ListNode result = null;
        for (ListNode li : lists) {
            result = merge(result, li);
        }
        return result;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                curr.next = list2;
                list2 = list2.next;
            } else {
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;
        }

        if (list1 == null) {
            curr.next = list2;
        } else {
            curr.next = list1;
        }

        return dummy.next;
    }
}
package com.ds.rani.heap;

/**
 *
 */

//Approach: At I time I am only taking 2 lists, then merging it. Recursively merging 2 lists at a time
// and finally returning one lists

//Time complexity:o(N log k) where k is number of lists and N is total number of elements in all the lists
// o(N) for merging and o(K) for partitioning

//Space complexity: o(log K) on recursive stack, where K is number of lists

public class MergeKSortedLists {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists == null) return null;
        return partition( lists, 0, lists.length - 1 );

    }

    ListNode partition(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];

        int mid = (start + end) / 2;

        ListNode list1 = partition( lists, start, mid );
        ListNode list2 = partition( lists, mid + 1, end );
        return mergeTwoLists( list1, list2 );

    }

    /**
     * Merge 2 sorted lists
     *
     * @param l1 list 1
     * @param l2 list 2
     * @return merged lists
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode( 0 );
        ListNode curr = l3;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else if (l2.val < l1.val) {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        //copy remaining elements of l1 if any
        if (l1 != null) {
            curr.next = l1;

        }
        //copy remaining elements of l2 if any
        if (l2 != null) {
            curr.next = l2;
        }

        return l3.next;
    }
}


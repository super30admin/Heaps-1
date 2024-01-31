/*
* Approach:
*  1. Merging K lists using Divide and Conquer.
    Start dividing the entire lists array into two half using start and end.
* 
*  2. If start+1 == end, merge two lists and return the merged head pointer.
    else divide further using mid and return merged head of left and right pointer.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(nk* (logk))
    n - max elements in each list
    k - no of lists
* 
* Space Complexity: O(logk)
    recursion space
* 
*/


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeKListsDC {
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);

        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 != null)
            curr.next = list1;

        if (list2 != null)
            curr.next = list2;

        return dummy.next;
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start > end)
            return null;

        if (start == end)
            return lists[start];

        if (start + 1 == end) {
            return mergeTwoLists(lists[start], lists[end]);
        }

        int mid = start + ((end - start) / 2);

        ListNode left = mergeKLists(lists, start, mid);

        ListNode right = mergeKLists(lists, mid + 1, end);

        return mergeTwoLists(left, right);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }
}

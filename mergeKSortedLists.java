// Time Complexity : O(nk) where n is the number of nodes in the final LL upon merging 2 LL's
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class mergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        for (ListNode list : lists) {
            merged = merge(merged, list);
        }
        return merged.next;
    }
    private ListNode merge(ListNode ln1, ListNode ln2) {
        ListNode curr = new ListNode(-1);
        ListNode dummy = curr;
        while (ln1 != null && ln2 != null) {
            if (ln1.val < ln2.val) {
                curr.next = ln1;
                ln1 = ln1.next;
            } else {
                curr.next = ln2;
                ln2 = ln2.next;
            }
            curr = curr.next;
        }
        if (ln1 != null) curr.next = ln1;
        if (ln2 != null) curr.next = ln2;
        return dummy.next;
    }
}
/*
 * MergeKSortedLists
 *
 * Approach:
 * This implementation iteratively merges each input list into a running
 * accumulator list by repeatedly calling a two-list merge helper (mergeTwoList).
 * For each incoming list, we merge it with the current head which produces a
 * new merged list maintained in `head`.
 *
 * Time complexity: O(k * n) in the worst case where k is the number of lists
 * and n is the average length of each list (more precisely, O(k * N) where N
 * is average length; or O(k * total_nodes) depending on distribution). This is
 * less efficient than the heap-based or divide-and-conquer approaches for large k.
 * Space complexity: O(1) extra (in-place merging), ignoring the output list nodes.
 *
 * LeetCode: https://leetcode.com/problems/merge-k-sorted-lists/
 */

public class MergeKSortedLists {

    ListNode head;

    public ListNode mergeKLists(ListNode[] lists) {
        head = new ListNode(Integer.MIN_VALUE);
        for (ListNode node : lists) {
            mergeTwoList(head, node);
        }
        return head.next;
    }

    private void mergeTwoList(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode current = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        if (head1 != null) {
            current.next = head1;
        }
        if (head2 != null) {
            current.next = head2;
        }
        head = dummy.next;
    }
}

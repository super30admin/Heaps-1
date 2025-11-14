/*
 * ListNode
 *
 * Simple singly-linked list node used by many linked-list problems on LeetCode.
 *
 * Fields:
 *  - int val : node value
 *  - ListNode next : reference to the next node
 *
 * Time/Space: O(1) per node (structure only). Used across many problems tagged
 * with "linked-list" on LeetCode.
 *
 * LeetCode (linked list tag): https://leetcode.com/tag/linked-list/
 */

public class ListNode {
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

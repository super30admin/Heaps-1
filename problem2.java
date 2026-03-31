
    /**
    Time Complexity : O(N * K)
    Explanation:
    - We merge lists one by one.
    - Each merge takes O(N) and we do it K times.
    So total = O(N * K)

    Space Complexity : O(N)
    Explanation:
    We create new nodes while merging.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially confused about handling multiple lists.
    Solved it by repeatedly merging two lists.
    Also had to carefully handle equal values and remaining nodes.
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

    ListNode result;

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) return null;

        this.result = new ListNode();
        ListNode m = result;

        for (int i = 0; i < lists.length; i++) {
            result.next = mergeTwoSorted(result.next, lists[i]);
        }

        return m.next;
    }

    private ListNode mergeTwoSorted(ListNode list1, ListNode list2) {

        ListNode p1 = list1;
        ListNode p2 = list2;

        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        while (p1 != null && p2 != null) {

            if (p1.val < p2.val) {
                temp.next = new ListNode(p1.val);
                p1 = p1.next;
            }
            else if (p1.val > p2.val) {
                temp.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            else {
                // Both equal → add both
                temp.next = new ListNode(p1.val);
                temp = temp.next;

                temp.next = new ListNode(p2.val);
                p1 = p1.next;
                p2 = p2.next;
            }

            temp = temp.next;
        }

        // Remaining nodes
        while (p1 != null) {
            temp.next = new ListNode(p1.val);
            temp = temp.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            temp.next = new ListNode(p2.val);
            temp = temp.next;
            p2 = p2.next;
        }

        return dummy.next;
    }
}
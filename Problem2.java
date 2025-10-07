// Time Complexity : O(N log k) where N is the total number of elements in all linked lists and k is the number of linked lists in the input
// Space Complexity : O(k) since we are storing the k elements one each from k lists in the heap
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * Using a min heap to initially store one element from each list. When we get the node with minimum value out of the min heap, we add the next node in the min heap for comparison.
 */
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
        ListNode dummy = new ListNode(-1);
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null)
                pq.add(node);
        }

        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            if (temp.next != null) {
                pq.add(temp.next);
            }
            curr.next = temp;
            curr = curr.next;
        }

        return dummy.next;
    }
}
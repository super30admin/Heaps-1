import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(N*logk) where N = total number of nodes, k = number of linked lists
// Space Complexity : O(k) where k = number of linked lists
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//23. Merge k Sorted Lists (Hard) - https://leetcode.com/problems/merge-k-sorted-lists/
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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if (min.next != null) {
                pq.add(min.next);
            }
        }
        
        return result.next;
    }
}
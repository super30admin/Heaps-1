// Problem2 Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Time complexity - O(N log k) space - O(k) where N is the size of all nodes
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        
       PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        // Step 1: Add heads
        for(ListNode head: lists){
            if(head != null) minHeap.add(head);
        }
        
        ListNode result = new ListNode(0);
        ListNode cursor = result;
        while(!minHeap.isEmpty()){
            cursor.next = minHeap.poll();
            cursor = cursor.next;
            // add next smallest element of the polled list
            if(cursor.next != null) minHeap.add(cursor.next);
        }
        
        
        
        return result.next;
    }
}
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

 //Problem - Merge k Sorted Lists 
//Time Complexity - O(N log K) 
//Space Complexity - O(K) K is the number of lists
//Code run successfully on Leetcode - Yes
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Creating priority queue to store ListNode objects
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the heads of all lists to the min heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

       
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Continue until the min heap is not empty
        while (!minHeap.isEmpty()) {
            ListNode small = minHeap.poll();
            
            // Add the smallest node to the merged list
            current.next = small;
            current = current.next;

         
            if (small.next != null) {
                minHeap.offer(small.next);
            }
        }

        return dummy.next; // The merged sorted list starts from the next of the dummy node
    }
}

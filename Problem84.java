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
        if (lists == null || lists.length == 0) return null;
        
        // Priority queue (min-heap) to keep track of the nodes
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Initialize the heap with the head of each linked list
        for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);
            }
        }
        
        // Dummy head for the result list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Process the heap until it's empty
        while (!heap.isEmpty()) {
            ListNode minNode = heap.poll(); // Get the smallest node
            current.next = minNode; // Attach it to the result list
            current = current.next; // Move the pointer forward
            
            // If the current list has more nodes, push the next one into the heap
            if (minNode.next != null) {
                heap.add(minNode.next);
            }
        }
        
        // Return the merged list
        return dummy.next;
    }
}

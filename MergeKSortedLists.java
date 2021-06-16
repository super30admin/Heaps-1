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
/**
 * TC: O(nk logk)
 * SC: O(k)
 * Approach: Maintain a minHeap of heads of k LinkedLists
 *           Pop the node with minimum val, append it to the LinkedList, insert the next of that node into minHeap
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode current = dummyHead;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((a,b) -> a.val - b.val);
        
        
        // O(klogk) Populate minHeap with heads of k Linked lists
        for(ListNode listHead : lists) {
            if(listHead != null) {
                minHeap.add(listHead);
            }
        }
        
        // O(nk logk) Process all the nodes from all linked lists, take out minimum val node, add its next to minHeap
        while(!minHeap.isEmpty()) {
            ListNode currentMin = minHeap.poll();
            current.next = currentMin;
            
            if(currentMin.next != null) {
                minHeap.add(currentMin.next);
            }
            
            current = current.next;
        }
        
        return dummyHead.next;
    }
}

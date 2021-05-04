/*

Thought Process: Use Min Heap to store the intial heads of each list 
    -> Make a dummy node and a result node, point result to dummy.
    -> then loop through the minheap untill its empty
    -> then poll the top, mark dummy's next to it and push top's next to min heap if not null
    -> move dummy to dummy's next
    -> return result's next

Time Complexity - O(N) -> Since going through all the elements only once
Space Complexity - O(H) -> Max height of min heap. Where H is number of lists.

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
class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null) return null;
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode result = dummy;
        
        for(ListNode head : lists){
            if(head != null)
                minHeap.add(head);
        }
        
        while(!minHeap.isEmpty()){
            ListNode min = minHeap.poll();
            dummy.next = min;
            if(min.next != null)
                minHeap.add(min.next);
            dummy = dummy.next;
        }
        return result.next;
    }
}
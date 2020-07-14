/**
Time: O(N log K), space:O(K) for minheap
Algorithm:
=========
1. Create custom comparator of listnodes and then create minHeap with this custom comparator
2. Add all heads to the minHeap, use cursor as tail of processed list 
3. Now, connect popped node from minheap to cursor and move cursor to that node.
4. Popped node's next value would be offered to minHeap till null. Repeat till minHeap becomes empty
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        // create custom comparator
        Comparator<ListNode> customComparator = new Comparator<>() {
            public int compare(ListNode a, ListNode b) {
                return a.val-b.val;         // natural ordering as minheap, if maxHeap, then reverse ordering
            }
        };
        
        // create minHeap of listnodes 
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(customComparator);
        for(ListNode head: lists) {
            if(head != null)            // add all headnodes of lists to the minHeap
                minHeap.add(head);
        }
        

        ListNode cursor = dummy;

        while(!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();  // poll from min heap
            cursor.next = minNode;      // point cursor's next to the recently polled node
            cursor = cursor.next;       // update cursor
            if(minNode.next != null)
                minHeap.offer(minNode.next);    // Add minNode's next to the heap
        }
        
        
        return dummy.next;
    }
}
/*
23. Merge k Sorted Lists (HARD) - https://leetcode.com/problems/merge-k-sorted-lists/
Did this run successfully on Leetcode : Yes

Approach: Insert the first node of every list into a MIN Priority Queue.
As we poll elements off the queue, insert the next node of the node that was polled.
The idea is that at any point the queue will contain k elements.

TC: n * log(k) => n - total number of nodes, 2 operations (1 offer + 1 remove) will be performed on every node
    offer and remove both take O(log k) time. 
SC: O(k) => k nodes in PriorityQueue
*/
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
class MergeKSortedLL {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((p,q) -> p.val - q.val);
        ListNode dummyHead = new ListNode(-1);
        ListNode node = dummyHead;
        
        for (int i = 0; i < lists.length; i++) {
            ListNode l = lists[i];
            if (l != null) {
                pq.offer(l);
            }
        }
        
        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            node.next = new ListNode(smallest.val);
            node = node.next;
            
            if (smallest.next != null) {
                pq.offer(smallest.next);
            }
        }
        
        node.next = null;
        
        return dummyHead.next;
    }
}
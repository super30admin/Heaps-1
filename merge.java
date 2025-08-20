//Time Complexity: O(n * log k) where n is total number of nodes and k is number of lists
//Space Complexity: O(k) for the heap size.

//Push the head of each non-empty list into a min-heap keyed by node value.
//Repeatedly pop the smallest node, append it to the merged list, and push its next node (if any).
//Continue until the heap is empty; return the merged list starting at dummy.next.

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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val - b.val);
        for(ListNode list: lists){
            if(list != null){
                pq.add(list);
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null){
                pq.add(min.next);
            }
        }

        return dummy.next;
    }
}

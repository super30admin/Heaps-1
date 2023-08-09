// Time Complexity : O(nlogk) where n is the total number of nodes and k is the number of lists
// Space Complexity : O(k) where k is the number of lists
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
1. Create a minHeap and add all the heads of the lists to the heap.
2. Create a dummy node and a curr pointer to it.
3. While the heap is not empty, poll the top element from the heap and add it to the curr pointer.
4. If the polled element has a next element, add it to the heap.
5. Return the dummy.next.
 */

import java.util.PriorityQueue;

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
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for(ListNode head : lists){
            if(head != null)
                minHeap.offer(head);
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!minHeap.isEmpty()){
            ListNode currNode = minHeap.poll();
            curr.next = currNode;
            curr = curr.next;
            if(currNode.next != null){
                minHeap.offer(currNode.next);
            }
        }

        return dummy.next;
    }
}